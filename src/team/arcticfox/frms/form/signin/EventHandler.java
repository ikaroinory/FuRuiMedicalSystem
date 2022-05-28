package team.arcticfox.frms.form.signin;

import team.arcticfox.frms.account.Account;
import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.integration.message.MessageBox;
import team.arcticfox.frms.program.environment.Variable;

class EventHandler {
    static void signIn(String username, String password) {
        try {
            if (Account.signIn(username, password)) {
                MessageBox.show(MessageBox.Title.INFORMATION, "Login successful!", MessageBox.Icon.INFORMATION);
                Variable.mainPage.signInInitialize();
                Variable.signIn.dispose();
            } else {
                MessageBox.show(MessageBox.Title.INFORMATION, "Login failed!", MessageBox.Icon.INFORMATION);
                Variable.accountInfo = null;
                System.gc();
            }
        } catch (FuRuiException e) {
            e.displayMessageBox();
        }
    }
}
