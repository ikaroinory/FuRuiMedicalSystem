package team.arcticfox.frms.server.environment;

import com.alibaba.fastjson.JSON;
import team.arcticfox.frms.data.DateTime;
import team.arcticfox.frms.server.config.Config;
import team.arcticfox.frms.server.core.Command;
import team.arcticfox.frms.server.core.thread.RegisterServer;
import team.arcticfox.frms.server.core.thread.SignInServer;
import team.arcticfox.frms.system.Function;
import team.arcticfox.frms.system.SystemEnvironment;

public class Environment {
    public static Config config = null;
    public static Command command = null;
    public static SignInServer signInServer = null;
    public static RegisterServer registerServer = null;


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
        config = JSON.parseObject(Function.readFile(SystemEnvironment.PATH_CONFIG), Config.class);
    }

    public static void initialize() {
        loadConfig();
    }
}
