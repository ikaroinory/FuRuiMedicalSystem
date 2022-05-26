package team.arcticfox.frms.form.mainpage;

import team.arcticfox.frms.form.about.About;
import team.arcticfox.frms.form.register.Register;
import team.arcticfox.frms.form.signin.SignIn;
import team.arcticfox.frms.program.environment.Variable;

class EventHandler {
    static void initialize(MainPage mainPage) {
        mainPage.tabbedPane.removeAll();
        mainPage.tabbedPane.addTab("Welcome Page", mainPage.panelWelcomeVisit);
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
}
