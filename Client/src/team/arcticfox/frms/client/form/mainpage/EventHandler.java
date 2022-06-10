package team.arcticfox.frms.client.form.mainpage;

import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.client.form.about.About;
import team.arcticfox.frms.client.form.register.Register;
import team.arcticfox.frms.client.form.signin.SignIn;
import team.arcticfox.frms.client.form.view.View;
import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.data.MedicineInfo;
import team.arcticfox.frms.integration.message.MessageBox;
import team.arcticfox.frms.system.Function;
import team.arcticfox.frms.system.SystemEnvironment;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.List;

class EventHandler {
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
        System.exit(0);
    }

    static void showRegisterForm() {
        new Register();
    }

    static void showSignInForm() {
        Environment.signIn = new SignIn();
    }

    static void showAboutForm(MainPage mainPage) {
        new About(mainPage);
    }

    static void showView(MainPage mainPage) {
        int selectedRow = mainPage.tableMedicineList.getSelectedRow();
        if (selectedRow == -1)
            MessageBox.show(MessageBox.Title.ERROR, "Please select a row!", MessageBox.Icon.ERROR);
        else
            new View(Integer.parseInt(mainPage.tableMedicineList.getValueAt(selectedRow, 0).toString()));
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
