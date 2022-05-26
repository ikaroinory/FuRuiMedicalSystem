import team.arcticfox.frms.dataset.AccountPermission;
import team.arcticfox.frms.form.mainpage.MainPage;
import team.arcticfox.frms.form.signin.SignIn;
import team.arcticfox.frms.program.environment.*;
import team.arcticfox.frms.security.Base64;
import team.arcticfox.frms.security.MD5;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Variable.mainPage = new MainPage();
        Variable.signIn = new SignIn();
    }
}
