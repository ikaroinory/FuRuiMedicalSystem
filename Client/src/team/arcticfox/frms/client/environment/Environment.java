package team.arcticfox.frms.client.environment;

import team.arcticfox.frms.client.config.Config;
import team.arcticfox.frms.client.config.Settings;
import team.arcticfox.frms.client.form.about.About;
import team.arcticfox.frms.client.form.cart.Cart;
import team.arcticfox.frms.client.form.mainpage.MainPage;
import team.arcticfox.frms.client.form.register.Register;
import team.arcticfox.frms.client.form.settings.SettingsForm;
import team.arcticfox.frms.client.form.signin.SignIn;
import team.arcticfox.frms.client.function.Account;
import team.arcticfox.frms.data.AccountInfo;
import team.arcticfox.frms.data.ShoppingCart;
import team.arcticfox.frms.system.Function;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public final class Environment {
    public static final String DIR_CONFIG = "./config/";
    public static final String DIR_LANG = "./lang/";
    public static final String FILE_CONFIG = "config.json";
    public static final String FILE_SETTINGS = "settings.json";
    public static final String PATH_CONFIG = DIR_CONFIG + FILE_CONFIG;
    public static final String PATH_SETTINGS = DIR_CONFIG + FILE_SETTINGS;


    public static Config config = null;
    public static Settings settings = null;
    public static Language language = null;

    public static AccountInfo accountInfo = null;
    public static ShoppingCart cart = null;

    public static MainPage mainPage = null;
    public static SignIn signIn = null;
    public static Register register = null;
    public static About about = null;
    public static Cart cartForm = null;
    public static SettingsForm settingsForm = null;


    public static void copyToClipboard(String s) {
        StringSelection stringSelection = new StringSelection(s);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    private static void loadConfig() {
        config = Config.parse(Function.readFile(PATH_CONFIG));
        settings = Settings.parse(Function.readFile(PATH_SETTINGS));
        language = Language.parse(Function.readFile(DIR_LANG + settings.language + ".json"));
    }

    public static void initialize() {
        loadConfig();
    }

    public static void exit(int status) {
        Account.signOut();
        System.exit(status);
    }
}
