package team.arcticfox.frms.account;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.dataset.AccountInfo;
import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.exception.account.*;
import team.arcticfox.frms.program.environment.Constant;
import team.arcticfox.frms.program.environment.Variable;
import team.arcticfox.frms.security.MD5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class Account {
    private static boolean isNotComplex(String password) {
        String pattern = "^.*(?=.{8,16})(?=.*\\d)(?=.*[A-Z]+)(?=.*[a-z]+)(?=.*[!@#$%^&*?()]).*$";
        return !Pattern.matches(pattern, password);
    }

    private static AccountInfo getAccountInfo(String username) {
        AccountInfo accountInfo = null;
        Database db = new Database(Constant.DB_NAME);
        db.open();
        ResultSet rs = db.sqlQuery(Variable.getQueryByNameSQL(username));
        try {
            if (rs.first()) {
                accountInfo = AccountInfo.Parse(rs);
            }
            rs.close();
        } catch (SQLException e) {
            // Do nothing.
        }
        db.close();
        return accountInfo;
    }

    public static boolean signIn(String username, String password) throws FuRuiException {
        if (username.equals("")) throw new UsernameIsEmptyException();
        if (password.equals("")) throw new PasswordIsEmptyException();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("password", password);
        String code = "";
        try {
            Socket socket = new Socket("localhost", 25566);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            out.writeUTF(jsonObject.toJSONString());
            code = in.readUTF();
            Variable.accountInfo = JSON.parseObject(in.readUTF(), AccountInfo.class);

            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (code.equals("AC1001")) throw new UserNotFoundException();
        return code.equals("NULL");
    }
    /*
    public static boolean signIn(String username, String password) throws FuRuiException {
        if (username.equals("")) throw new UsernameIsEmptyException();
        if (password.equals("")) throw new PasswordIsEmptyException();

        // out(Base64.encode(username), Base64.encode(password))
        // Network Transmission......
        // in(Base64.decode(username), Base64.decode(password))

        Variable.accountInfo = getAccountInfo(username);
        if (Variable.accountInfo == null) throw new UserNotFoundException();

        if (MD5.encode(password).equals(Variable.accountInfo.getPassword())) {
            Database db = new Database(Constant.DB_NAME);
            db.open();
            db.sqlUpdate(Variable.getUpdateLastLoginTimeSQL(Variable.accountInfo.getId()));
            db.close();
            return true;
        } else
            return false;
    }

     */

    public static boolean signOut() {
        Variable.accountInfo = null;
        System.gc();
        return Variable.accountInfo == null;
    }

    public static boolean register(String username, String email, String password, String verifyPassword) throws FuRuiException {
        if (username.equals("")) throw new UsernameIsEmptyException();
        if (email.equals("")) throw new EmailIsEmptyException();
        if (password.equals("")) throw new PasswordIsEmptyException();
        if (!password.equals(verifyPassword)) throw new DifferentPasswordException();
        if (isNotComplex(password)) throw new PasswordIsEasyException();

        // out(Base64.encode(username), Base64.encode(email), Base64.encode(password))
        // Network Transmission......
        // in(Base64.decode(username), Base64.decode(email), Base64.decode(password))

        Variable.accountInfo = getAccountInfo(username);
        if (Variable.accountInfo != null) throw new UsernameExistsException();
        Database db = new Database(Constant.DB_NAME);
        db.open();
        // System.out.println(Variable.getInsertUserSQL(username, email, password));
        db.sqlUpdate(Variable.getInsertUserSQL(username, email, password));
        db.close();

        return getAccountInfo(username) != null;
    }
}
