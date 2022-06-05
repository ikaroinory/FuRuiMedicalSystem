import team.arcticfox.frms.form.mainpage.MainPage;
import team.arcticfox.frms.form.signin.SignIn;
import team.arcticfox.frms.form.view.View;
import team.arcticfox.frms.program.environment.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Variable.mainPage = new MainPage();
        Variable.signIn = new SignIn();
        new View(1);
    }
}
