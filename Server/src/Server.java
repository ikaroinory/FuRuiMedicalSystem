import team.arcticfox.frms.data.DateTime;
import team.arcticfox.frms.server.core.Command;
import team.arcticfox.frms.server.thread.*;
import team.arcticfox.frms.server.environment.Environment;

public final class Server {
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
        Environment.cartServer = new CartServer();
        Environment.orderServer = new OrderServer();
        Environment.userToServerChatServer = new UserToServerChatServer();
        Environment.serverToServiceChatServer = new ServerToServiceChatServer();
        Environment.serviceToServerChatServer = new ServiceToServerChatServer();
        Environment.serverToUserChatServer = new ServerToUserChatServer();

        Environment.command.start();
        Environment.signInServer.start();
        Environment.registerServer.start();
        Environment.cartServer.start();
        Environment.orderServer.start();
        Environment.userToServerChatServer.start();
        Environment.serverToServiceChatServer.start();
        Environment.serviceToServerChatServer.start();
        Environment.serverToUserChatServer.start();
    }

    public static void main(String[] args) throws Exception {
        initialize();

        System.out.println(getWelcomeWords());
    }
}
