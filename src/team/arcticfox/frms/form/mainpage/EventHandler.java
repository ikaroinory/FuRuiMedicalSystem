package team.arcticfox.frms.form.mainpage;

import team.arcticfox.frms.account.Account;
import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.dataset.MedicineInfo;
import team.arcticfox.frms.form.about.About;
import team.arcticfox.frms.form.register.Register;
import team.arcticfox.frms.form.signin.SignIn;
import team.arcticfox.frms.program.environment.Constant;
import team.arcticfox.frms.program.environment.Variable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.util.List;

class EventHandler {
    static void initialize(MainPage mainPage) {
        mainPage.tabbedPane.removeAll();                                                    // Remove all tabs.
        mainPage.tabbedPane.addTab("Welcome Page", mainPage.panelWelcomeVisit);        // Add welcome page.

        mainPage.tableMedicineList.getTableHeader().setReorderingAllowed(false);            // Prohibit column movement.
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JTextField.CENTER);
        mainPage.tableMedicineList.getColumn(Constant.COLUMNLABEL_ID).setCellRenderer(r);
        mainPage.tableMedicineList.getColumn(Constant.COLUMNLABEL_TYPE).setCellRenderer(r);
        mainPage.tableMedicineList.getColumn(Constant.COLUMNLABEL_PRICE).setCellRenderer(r);
        mainPage.tableMedicineList.getColumn(Constant.COLUMNLABEL_AMOUNT).setCellRenderer(r);
    }

    static void exit() {
        System.exit(0);
    }

    static void showRegisterForm() {
        new Register();
    }

    static void showSignInForm() {
        Variable.signIn = new SignIn();
    }

    static void showAboutForm(MainPage mainPage) {
        new About(mainPage);
    }

    static void refresh(MainPage mainPage) {
        ((DefaultTableModel) mainPage.tableMedicineList.getModel()).getDataVector().clear();
        ((DefaultTableModel) mainPage.tableMedicineList.getModel()).fireTableDataChanged();
        mainPage.tableMedicineList.updateUI();

        Database db = new Database(Constant.DB_NAME);
        db.open();
        List<MedicineInfo> list = MedicineInfo.parse(db.sqlQuery(Variable.getQueryMedicineListSQL()));
        for (MedicineInfo medicineInfo : list)
            ((DefaultTableModel) mainPage.tableMedicineList.getModel()).addRow(medicineInfo.toObjectList());
        db.close();
    }
}
