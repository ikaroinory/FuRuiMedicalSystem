import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.form.register.Register;
import team.arcticfox.frms.program.environment.*;
import team.arcticfox.frms.security.Base64;
import team.arcticfox.frms.security.RSA;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame t = new Register();
        System.out.println(t.getSize().width);
        System.out.println(t.getSize().height);
    }
}
