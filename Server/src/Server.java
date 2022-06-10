import team.arcticfox.frms.server.core.Command;
import team.arcticfox.frms.server.core.thread.RegisterServer;
import team.arcticfox.frms.server.core.thread.SignInServer;
import team.arcticfox.frms.server.environment.Environment;

public class Server {
    private static final String WELCOME_WORDS = "FuRui Medical System Server 2022 - [%ip%:%port%]";

    public static String getWelcomeWords() {
        String s = WELCOME_WORDS;
        s = s.replaceAll("%ip%", Environment.config.server.address.ip);
        s = s.replaceAll("%port%", String.valueOf(Environment.config.server.address.port));
        return s;
    }

    private static void initialize() {
        Environment.initialize();

        Environment.command = new Command();
        Environment.signInServer = new SignInServer();
        Environment.registerServer = new RegisterServer();

        Environment.command.start();
        Environment.signInServer.start();
        Environment.registerServer.start();
    }

    public static void main(String[] args) throws Exception {
        initialize();

        System.out.println(getWelcomeWords());
    }
}
