import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.client.form.mainpage.MainPage;
import team.arcticfox.frms.client.form.signin.SignIn;

public final class Client {
    public static void main(String[] args) {
        Environment.initialize();

        Environment.mainPage = new MainPage();
        Environment.signIn = new SignIn();
    }
}
