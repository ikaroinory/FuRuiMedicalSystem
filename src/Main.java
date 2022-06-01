import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.dataset.MedicineInfo;
import team.arcticfox.frms.form.mainpage.MainPage;
import team.arcticfox.frms.form.signin.SignIn;
import team.arcticfox.frms.program.environment.*;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class Main extends Thread {
    private static void testFunction() {
        while (true) {
            Scanner in = new Scanner(System.in);
            String cmd = in.next();
            if (cmd.equals("userinfo"))
                System.out.println(Variable.accountInfo);
            if (cmd.equals("exit"))
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        Variable.mainPage = new MainPage();
        Variable.signIn = new SignIn();
    }
}
