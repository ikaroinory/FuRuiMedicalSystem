package team.arcticfox.frms.client.form.register;

import team.arcticfox.frms.client.function.Account;
import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.integration.message.MessageBox;

final class EventHandler {
    static void register(Register register,String username, String email, String password, String verifyPassword) {
        try {
            if (Account.register(username, email, password, verifyPassword)){
                MessageBox.show(MessageBox.Title.INFORMATION, "Register successful!", MessageBox.Icon.INFORMATION);
                register.dispose();
            }
            else
                MessageBox.show(MessageBox.Title.INFORMATION, "Register failed!", MessageBox.Icon.INFORMATION);
        } catch (FuRuiException e) {
            e.displayMessageBox();
        }
    }
}
