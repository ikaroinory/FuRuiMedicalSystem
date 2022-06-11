package team.arcticfox.frms.client.environment;

import com.alibaba.fastjson.JSON;
import team.arcticfox.frms.client.config.Config;
import team.arcticfox.frms.client.form.about.About;
import team.arcticfox.frms.client.form.cart.Cart;
import team.arcticfox.frms.client.form.mainpage.MainPage;
import team.arcticfox.frms.client.form.register.Register;
import team.arcticfox.frms.client.form.signin.SignIn;
import team.arcticfox.frms.client.function.CartFunction;
import team.arcticfox.frms.data.AccountInfo;
import team.arcticfox.frms.data.ShoppingCart;
import team.arcticfox.frms.system.Function;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public final class Environment {
    public static final String DIR_CONFIG = "./config/";
    public static final String FILE_CONFIG = "config.json";
    public static final String PATH_CONFIG = DIR_CONFIG + FILE_CONFIG;


    public static Config config = null;
    public static AccountInfo accountInfo = null;
    public static ShoppingCart cart = null;

    public static MainPage mainPage = null;
    public static SignIn signIn = null;
    public static Register register = null;
    public static About about = null;
    public static Cart cartForm = null;


    public static void copyToClipboard(String s) {
        StringSelection stringSelection = new StringSelection(s);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    private static void loadConfig() {
        config = JSON.parseObject(Function.readFile(PATH_CONFIG), Config.class);
    }

    public static void initialize() {
        loadConfig();

    }

    public static void exit(int status) {
        // 同步购物车到server
        if (accountInfo != null)
            CartFunction.update();
        System.exit(status);
    }
}
