package team.arcticfox.frms.form.register;

import team.arcticfox.frms.account.Account;
import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.integration.messag.MessageBox;

class EventHandler {
    static void register(String username, String email, String password, String verifyPassword) {
        try {
            if (Account.register(username, email, password, verifyPassword))
                MessageBox.show(MessageBox.Title.INFORMATION, "Register successful!", MessageBox.Icon.INFORMATION);
            else
                MessageBox.show(MessageBox.Title.INFORMATION, "Register failed!", MessageBox.Icon.INFORMATION);
        } catch (FuRuiException e) {
            e.displayMessageBox();
        }
    }
}
