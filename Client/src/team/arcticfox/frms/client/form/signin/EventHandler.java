package team.arcticfox.frms.client.form.signin;

import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.client.function.Account;
import team.arcticfox.frms.data.ShoppingCart;
import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.integration.message.MessageBox;

final class EventHandler {
    static void signIn(String username, String password) {
        try {
            if (Account.signIn(username, password)) {
                MessageBox.show(MessageBox.Title.INFORMATION, "Login successful!", MessageBox.Icon.INFORMATION);
                Environment.mainPage.signInInitialize();
                Environment.signIn.dispose();
                Environment.signIn = null;
            } else {
                MessageBox.show(MessageBox.Title.INFORMATION, "Login failed!", MessageBox.Icon.INFORMATION);
                Environment.accountInfo = null;
                System.gc();
            }
        } catch (FuRuiException e) {
            e.displayMessageBox();
        }
    }
}
