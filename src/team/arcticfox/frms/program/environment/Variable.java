package team.arcticfox.frms.program.environment;

import team.arcticfox.frms.dataset.AccountInfo;
import team.arcticfox.frms.dataset.AccountPermission;
import team.arcticfox.frms.form.mainpage.MainPage;
import team.arcticfox.frms.form.signin.SignIn;
import team.arcticfox.frms.security.Base64;
import team.arcticfox.frms.security.MD5;

public class Variable {
    public static AccountInfo accountInfo = null;

    public static MainPage mainPage = null;
    public static SignIn signIn = null;

    public static String getQueryByName(String username) {
        return "SELECT * FROM `" + Constant.DB_NAME + "`.`" + Constant.TABLE_ACCOUNTINFO + "` "
                + "WHERE `username` = '" + Base64.encode(username) + "'";
    }

    public static String getInsertUser(String username, String email, String password) {
        System.out.println(password);
        return "INSERT INTO `" + Constant.DB_NAME + "`.`" + Constant.TABLE_ACCOUNTINFO + "` (" +
                "`" + Constant.COLUMNLABEL_USERNAME + "`, " +
                "`" + Constant.COLUMNLABEL_EMAIL + "`, " +
                "`" + Constant.COLUMNLABEL_PASSWORD + "`, " +
                "`" + Constant.COLUMNLABEL_PERMISSION + "`, " +
                "`" + Constant.COLUMNLABEL_REGISTRATIONTIME + "`" +
                ") VALUES (" +
                "'" + Base64.encode(username) + "', " +
                "'" + Base64.encode(email) + "', " +
                "'" + Base64.encode(MD5.encode(password)) + "', " +
                "'" + AccountPermission.USER + "', " +
                "NOW()" +
                ")";
    }
}
