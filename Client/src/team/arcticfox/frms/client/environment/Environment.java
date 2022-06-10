package team.arcticfox.frms.client.environment;

import com.alibaba.fastjson.JSON;
import team.arcticfox.frms.client.config.Config;
import team.arcticfox.frms.client.form.mainpage.MainPage;
import team.arcticfox.frms.client.form.register.Register;
import team.arcticfox.frms.client.form.signin.SignIn;
import team.arcticfox.frms.data.AccountInfo;
import team.arcticfox.frms.system.Function;
import team.arcticfox.frms.system.SystemEnvironment;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class Environment {
    public static Config config = null;
    public static AccountInfo accountInfo = null;
    public static MainPage mainPage = null;
    public static SignIn signIn = null;
    public static Register register = null;

    public static void copyToClipboard(String s) {
        StringSelection stsel = new StringSelection(s);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel, null);
    }

    private static void loadConfig() {
        config = JSON.parseObject(Function.readFile(SystemEnvironment.PATH_CONFIG), Config.class);
    }

    public static void initialize() {
        loadConfig();
    }
}
