import team.arcticfox.frms.dataset.AccountPermission;
import team.arcticfox.frms.form.mainpage.MainPage;
import team.arcticfox.frms.form.signin.SignIn;
import team.arcticfox.frms.program.environment.*;
import team.arcticfox.frms.security.Base64;
import team.arcticfox.frms.security.MD5;

import javax.swing.*;
import java.util.Scanner;

public class Main extends Thread {
    private static void testFunction() {
        while (true) {
            Scanner in = new Scanner(System.in);
            String cmd = in.next();
            if (cmd.equals("userinfo"))
                System.out.println(Variable.accountInfo);
            if(cmd.equals("exit"))
                break;
        }
    }

    public static void main(String[] args) {
        Variable.mainPage = new MainPage();
        Variable.signIn = new SignIn();

        testFunction();
    }
}
