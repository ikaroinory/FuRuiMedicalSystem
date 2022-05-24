package team.arcticfox.frms.form.mainpage;

import team.arcticfox.frms.form.register.Register;
import team.arcticfox.frms.form.signin.SignIn;

public class EventHandler {
    public static void exit() {
        System.exit(0);
    }

    public static void showRegisterForm() {
        new Register();
    }

    public static void showSignInForm() {
        new SignIn();
    }
}
