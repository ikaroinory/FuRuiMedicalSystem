package team.arcticfox.frms.client.form.register;

import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.client.function.Account;
import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.integration.message.MessageBox;

final class EventHandler {
    private static void loadLang(Register register) {
        register.setTitle(Environment.language.form.register.formTitle);
        register.labelUsername.setText(Environment.language.form.register.labelUsername);
        register.labelEmail.setText(Environment.language.form.register.labelEmail);
        register.labelPassword.setText(Environment.language.form.register.labelPassword);
        register.labelVerificationPassword.setText(Environment.language.form.register.labelVerifyPassword);
        register.buttonRegister.setText(Environment.language.form.register.buttonRegister);
    }

    static void initialize(Register register) {
        loadLang(register);
    }

    static void register(Register register, String username, String email, String password, String verifyPassword) {
        try {
            if (Account.register(username, email, password, verifyPassword)) {
                MessageBox.show(MessageBox.Title.INFORMATION, "Register successful!", MessageBox.Icon.INFORMATION);
                register.dispose();
            } else
                MessageBox.show(MessageBox.Title.INFORMATION, "Register failed!", MessageBox.Icon.INFORMATION);
        } catch (FuRuiException e) {
            e.displayMessageBox();
        }
    }
}
