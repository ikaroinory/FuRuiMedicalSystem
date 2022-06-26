package team.arcticfox.frms.server.environment;

import com.alibaba.fastjson.JSON;
import team.arcticfox.frms.data.DateTime;
import team.arcticfox.frms.server.config.Config;
import team.arcticfox.frms.server.core.Command;
import team.arcticfox.frms.server.thread.*;
import team.arcticfox.frms.system.Function;

public final class Environment {
    public static final String DIR_CONFIG = "./config/";
    public static final String DIR_CARTS = "./carts/";
    public static final String DIR_ORDER = "./order/";
    public static final String FILE_CONFIG = "config.json";
    public static final String PATH_CONFIG = DIR_CONFIG + FILE_CONFIG;

    public static Config config = null;
    public static Command command = null;
    public static SignInServer signInServer = null;
    public static RegisterServer registerServer = null;
    public static CartServer cartServer = null;
    public static OrderServer orderServer = null;
    public static UserToServerChatServer userToServerChatServer = null;
    public static ServerToServiceChatServer serverToServiceChatServer = null;
    public static ServiceToServerChatServer serviceToServerChatServer = null;
    public static ServerToUserChatServer serverToUserChatServer = null;


    public static void printInfo(String info) {
        System.out.println("[Info]\t\t" + info);
    }
    public static void printError(String error) {
        System.err.println("[Error]\t\t" + error);
    }
    public static void printSession(String info) {
        System.out.println("[Session]\t[" + DateTime.now() + "]\t" + info);
    }
    private static void loadConfig() {
        config = JSON.parseObject(Function.readFile(PATH_CONFIG), Config.class);
    }
    public static void initialize() {
        loadConfig();
    }
}
