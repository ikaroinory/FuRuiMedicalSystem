package team.arcticfox.frms.system;

import team.arcticfox.frms.data.DateTime;
import team.arcticfox.frms.security.Base64;
import team.arcticfox.frms.security.MD5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class Function {
    private static final String PATH_TABLE_ACCOUNT_INFO = "`" + SystemEnvironment.DB_NAME + "`.`" + SystemEnvironment.TABLE_ACCOUNT_INFO + "`";
    public static final String PATH_TABLE_MEDICINE_LIST = "`" + SystemEnvironment.DB_NAME + "`.`" + SystemEnvironment.TABLE_MEDICINE_LIST + "`";

    public static String readFile(String path) {
        String s = "";
        try {
            FileInputStream fin = new FileInputStream(path);
            s = new String(fin.readAllBytes());
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String getSQL_Query_AccountInfo_ByName(String username) {
        return "SELECT * FROM " + PATH_TABLE_ACCOUNT_INFO + " WHERE `username` = '" + Base64.encode(username) + "'";
    }

    public static String getSQL_Update_AccountInfo_UpdateLastLoginTime(int id) {
        return "UPDATE " + PATH_TABLE_ACCOUNT_INFO + " SET `Last Login Time` = NOW() WHERE `Id` = " + id;
    }

    public static String getSQL_Update_AccountInfo_InsertUser(String username, String email, String password) {
        return "INSERT INTO " + PATH_TABLE_ACCOUNT_INFO + " (" +
                "`" + SystemEnvironment.COLUMN_USERNAME + "`, " +
                "`" + SystemEnvironment.COLUMN_EMAIL + "`, " +
                "`" + SystemEnvironment.COLUMN_PASSWORD + "`, " +
                "`" + SystemEnvironment.COLUMN_PERMISSION + "`" +
                ") VALUES (" +
                "'" + Base64.encode(username) + "', " +
                "'" + Base64.encode(email) + "', " +
                "'" + Base64.encode(MD5.encode(password)) + "', " +
                "'" + "User" + "'" +
                ")";
    }

    public static String getSQL_Query_MedicineList_ById(int id) {
        return "SELECT * FROM " + PATH_TABLE_MEDICINE_LIST + " WHERE `" + SystemEnvironment.COLUMN_ID + "` = '" + id + "'";
    }

    public static String getSQL_Query_MedicineList_ByApprovalNo(String approvalNo) {
        return "SELECT * FROM " + PATH_TABLE_MEDICINE_LIST + " WHERE `" + SystemEnvironment.COLUMN_APPROVAL_NO + "` = '" + approvalNo + "'";
    }

    public static String getSQL_Query_MedicineList_All() {
        return "SELECT * FROM " + PATH_TABLE_MEDICINE_LIST;
    }

    public static String getTimeStamp(DateTime dateTime) {
        String no = "";
        int[] list = {
                dateTime.month, dateTime.day,
                dateTime.hour, dateTime.minute, dateTime.second
        };
        no += dateTime.year;
        for (int i : list) {
            if (i < 10)
                no += '0';
            no += i;
        }
        Random random = new Random(dateTime.timeToLong());
        no += 1000 + Math.abs(random.nextInt()) % 9000;
        return no;
    }
}
