package team.arcticfox.frms.client.form.mainpage;

import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.client.form.about.About;
import team.arcticfox.frms.client.form.cart.Cart;
import team.arcticfox.frms.client.form.register.Register;
import team.arcticfox.frms.client.form.signin.SignIn;
import team.arcticfox.frms.client.form.view.View;
import team.arcticfox.frms.data.ShoppingItem;
import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.data.MedicineInfo;
import team.arcticfox.frms.integration.message.MessageBox;
import team.arcticfox.frms.system.Function;
import team.arcticfox.frms.system.SystemEnvironment;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.List;

final class EventHandler {
    static void initialize(MainPage mainPage) {
        mainPage.tabbedPane.removeAll();                                                    // Remove all tabs.
        mainPage.tabbedPane.addTab("Welcome Page", mainPage.panelWelcomeVisit);        // Add welcome page.

        mainPage.tableMedicineList.getTableHeader().setReorderingAllowed(false);            // Prohibit column movement.
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JTextField.CENTER);
        mainPage.tableMedicineList.getColumn(SystemEnvironment.COLUMN_ID).setCellRenderer(r);
        mainPage.tableMedicineList.getColumn(SystemEnvironment.COLUMN_APPROVAL_NO).setCellRenderer(r);
        mainPage.tableMedicineList.getColumn(SystemEnvironment.COLUMN_TYPE).setCellRenderer(r);
        mainPage.tableMedicineList.getColumn(SystemEnvironment.COLUMN_PRICE).setCellRenderer(r);
        mainPage.tableMedicineList.getColumn(SystemEnvironment.COLUMN_AMOUNT).setCellRenderer(r);
    }

    static void exit() {
        Environment.exit(0);
    }

    static void showRegisterForm() {
        if (Environment.register == null)
            Environment.register = new Register();
        else
            Environment.register.setVisible(true);
    }

    static void showSignInForm() {
        if (Environment.signIn == null)
            Environment.signIn = new SignIn();
        else
            Environment.signIn.setVisible(true);
    }

    static void showAboutForm(MainPage mainPage) {
        if (Environment.about == null)
            Environment.about = new About(mainPage);
        else
            Environment.about.setVisible(true);
    }

    static void showView(MainPage mainPage) {
        int selectedRow = mainPage.tableMedicineList.getSelectedRow();
        if (selectedRow == -1)
            MessageBox.show(MessageBox.Title.ERROR, "Please select a row!", MessageBox.Icon.ERROR);
        else
            new View(Integer.parseInt(mainPage.tableMedicineList.getValueAt(selectedRow, 0).toString()));
    }

    static void showCart() {
        if (Environment.cartForm == null)
            Environment.cartForm = new Cart();
        else
            Environment.cartForm.setVisible(true);
    }

    static void addToCart(MainPage mainPage) {
        int selectedRow = mainPage.tableMedicineList.getSelectedRow();
        if (selectedRow == -1)
            MessageBox.show(MessageBox.Title.ERROR, "Please select a row!", MessageBox.Icon.ERROR);
        else {
            int id = (int) mainPage.tableMedicineList.getValueAt(selectedRow, 0);
            Database db = new Database(Environment.config.database.address.ip, Environment.config.database.address.port, SystemEnvironment.DB_NAME);
            db.open(Environment.config.database.root.username, Environment.config.database.root.password);
            MedicineInfo info = MedicineInfo.parse(db.sqlQuery(Function.getSQL_Query_MedicineList_ById(id))).get(0);
            db.close();

            Environment.cart.add(new ShoppingItem(
                    info.id,
                    info.medicineName,
                    info.manufacturer,
                    info.specification,
                    info.price,
                    1
            ));
            if (Environment.cartForm != null)
                team.arcticfox.frms.client.form.cart.EventHandler.refresh(Environment.cartForm);
        }
    }

    static void refresh(MainPage mainPage) {
        ((DefaultTableModel) mainPage.tableMedicineList.getModel()).getDataVector().clear();
        ((DefaultTableModel) mainPage.tableMedicineList.getModel()).fireTableDataChanged();
        mainPage.tableMedicineList.updateUI();

        Database db = new Database(Environment.config.database.address.ip, Environment.config.database.address.port, SystemEnvironment.DB_NAME);
        db.open(Environment.config.database.root.username, Environment.config.database.root.password);
        List<MedicineInfo> list = MedicineInfo.parse(db.sqlQuery(Function.getSQL_Query_MedicineList_All()));
        for (MedicineInfo medicineInfo : list)
            ((DefaultTableModel) mainPage.tableMedicineList.getModel()).addRow(medicineInfo.toObjectList());
        db.close();
    }
}
