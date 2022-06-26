package team.arcticfox.frms.client.form.mainpage;

import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.client.form.about.About;
import team.arcticfox.frms.client.form.cart.Cart;
import team.arcticfox.frms.client.form.chat.Chat;
import team.arcticfox.frms.client.form.register.Register;
import team.arcticfox.frms.client.form.settings.SettingsForm;
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
    private static void loadLang(MainPage mainPage) {
        mainPage.setTitle(Environment.language.form.mainPage.formTitle.replaceAll("%version%", Environment.config.version));
        mainPage.menuFile.setText(Environment.language.form.mainPage.menuFile);
        mainPage.menuAccount.setText(Environment.language.form.mainPage.menuAccount);
        mainPage.menuManagement.setText(Environment.language.form.mainPage.menuManagement);
        mainPage.menuHelp.setText(Environment.language.form.mainPage.menuHelp);
        mainPage.menuItemSettings.setText(Environment.language.form.mainPage.menuItemSettings);
        mainPage.menuItemExit.setText(Environment.language.form.mainPage.menuItemExit);
        mainPage.menuItemRegister.setText(Environment.language.form.mainPage.menuItemRegister);
        mainPage.menuItemSignIn.setText(Environment.language.form.mainPage.menuItemSignIn);
        mainPage.menuItemSignOut.setText(Environment.language.form.mainPage.menuItemSignOut);
        mainPage.menuItemViewCart.setText(Environment.language.form.mainPage.menuItemViewCart);
        mainPage.menuItemUserManagement.setText(Environment.language.form.mainPage.menuItemUserManagement);
        mainPage.menuItemMedicineManagement.setText(Environment.language.form.mainPage.menuItemMedicineManagement);
        mainPage.menuItemOnlineService.setText(Environment.language.form.mainPage.menuItemOnlineService);
        mainPage.menuItemCheckUpdate.setText(Environment.language.form.mainPage.menuItemCheckUpdate);
        mainPage.menuItemAbout.setText(Environment.language.form.mainPage.menuItemAbout);

        // tab

        mainPage.buttonRefresh.setText(Environment.language.form.mainPage.buttonRefresh);
        mainPage.buttonViewDetails.setText(Environment.language.form.mainPage.buttonViewDetails);
        mainPage.buttonAddToCart.setText(Environment.language.form.mainPage.buttonAddToCart);
        mainPage.buttonViewCart.setText(Environment.language.form.mainPage.buttonViewCart);
        mainPage.labelWelcomeTitleVisit.setText(Environment.language.form.mainPage.labelWelcome);
        mainPage.labelWelcomeContentVisit.setText(Environment.language.form.mainPage.labelWelcomePageVisit);
        mainPage.labelWelcomeTitle.setText(Environment.language.form.mainPage.labelWelcome);
        mainPage.labelWelcomeContent.setText(Environment.language.form.mainPage.labelWelcomePage);
    }

    static void initialize(MainPage mainPage) {
        loadLang(mainPage);

        mainPage.tabbedPane.removeAll();                                                    // Remove all tabs.
        mainPage.tabbedPane.addTab(Environment.language.form.mainPage.tabWelcomePage, mainPage.panelWelcomeVisit);

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
    static void showSettingsForm() {
        if (Environment.settingsForm == null)
            Environment.settingsForm = new SettingsForm();
        else
            Environment.settingsForm.setVisible(true);
    }
    static void showView(MainPage mainPage) {
        int selectedRow = mainPage.tableMedicineList.getSelectedRow();
        if (selectedRow == -1)
            MessageBox.show(Environment.language.message.error.title, Environment.language.message.error.selectARow, MessageBox.Icon.ERROR);
        else
            new View(Integer.parseInt(mainPage.tableMedicineList.getValueAt(selectedRow, 0).toString()));
    }
    static void showCart() {
        if (Environment.cartForm == null)
            Environment.cartForm = new Cart();
        else
            Environment.cartForm.setVisible(true);
    }
    static void showChatForm() {
        if (Environment.chatForm == null)
            Environment.chatForm = new Chat();
        else
            Environment.chatForm.setVisible(true);
    }
    static void addToCart(MainPage mainPage) {
        int selectedRow = mainPage.tableMedicineList.getSelectedRow();
        if (selectedRow == -1)
            MessageBox.show(Environment.language.message.error.title, Environment.language.message.error.selectARow, MessageBox.Icon.ERROR);
        else {
            int id = (int) mainPage.tableMedicineList.getValueAt(selectedRow, 0);
            Database db = new Database(Environment.config.database.address.ip, Environment.config.database.address.port, SystemEnvironment.DB_NAME);
            db.open(Environment.config.database.root.username, Environment.config.database.root.password);
            MedicineInfo info = MedicineInfo.parse(db.sqlQuery(Function.getSQL_Query_MedicineList_ById(id))).get(0);
            db.close();

            Environment.cart.add(new ShoppingItem(info.id, info.medicineName, info.manufacturer, info.specification, info.price, 1, true));
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

        mainPage.tableMedicineList.getColumnModel().getColumn(0).setHeaderValue(Environment.language.form.mainPage.tableId);
        mainPage.tableMedicineList.getColumnModel().getColumn(1).setHeaderValue(Environment.language.form.mainPage.tableMedicineName);
        mainPage.tableMedicineList.getColumnModel().getColumn(2).setHeaderValue(Environment.language.form.mainPage.tableApprovalNo);
        mainPage.tableMedicineList.getColumnModel().getColumn(3).setHeaderValue(Environment.language.form.mainPage.tableManufacturer);
        mainPage.tableMedicineList.getColumnModel().getColumn(4).setHeaderValue(Environment.language.form.mainPage.tableType);
        mainPage.tableMedicineList.getColumnModel().getColumn(5).setHeaderValue(Environment.language.form.mainPage.tablePrice);
        mainPage.tableMedicineList.getColumnModel().getColumn(6).setHeaderValue(Environment.language.form.mainPage.tableAmount);
    }
}
