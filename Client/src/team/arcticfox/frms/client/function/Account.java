package team.arcticfox.frms.client.function;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.data.AccountInfo;
import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.exception.NullException;
import team.arcticfox.frms.exception.account.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.regex.Pattern;

public class Account {
    private static boolean isNotComplex(String password) {
        String pattern = "^.*(?=.{8,16})(?=.*\\d)(?=.*[A-Z]+)(?=.*[a-z]+)(?=.*[!@#$%^&*?()]).*$";
        return !Pattern.matches(pattern, password);
    }

    public static boolean signIn(String username, String password) throws FuRuiException {
        if (username.equals("")) throw new UsernameIsEmptyException();
        if (password.equals("")) throw new PasswordIsEmptyException();

        JSONObject jsonObject = new JSONObject(true) {
            {
                put("username", username);
                put("password", password);
            }
        };
        String exceptionCode = "";
        try {
            Socket socket = new Socket("172.16.57.21", 25566);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            out.writeUTF(jsonObject.toJSONString());
            exceptionCode = in.readUTF();
            Environment.accountInfo = JSON.parseObject(in.readUTF(), AccountInfo.class);

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!exceptionCode.equals(new NullException().code)) throw FuRuiException.parse(exceptionCode);

        return true;
    }

    public static boolean signOut() {
        Environment.accountInfo = null;
        System.gc();
        return Environment.accountInfo == null;
    }

    public static boolean register(String username, String email, String password, String verifyPassword) throws FuRuiException {
        if (username.equals("")) throw new UsernameIsEmptyException();
        if (email.equals("")) throw new EmailIsEmptyException();
        if (password.equals("")) throw new PasswordIsEmptyException();
        if (!password.equals(verifyPassword)) throw new DifferentPasswordException();
        if (isNotComplex(password)) throw new PasswordIsEasyException();

        JSONObject jsonObject = new JSONObject(true) {
            {
                put("username", username);
                put("email", email);
                put("password", password);
            }
        };
        String exceptionCode = "";
        try {
            Socket socket = new Socket("localhost", 25567);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            out.writeUTF(jsonObject.toJSONString());
            exceptionCode = in.readUTF();

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!exceptionCode.equals(new NullException().code)) throw FuRuiException.parse(exceptionCode);

        return true;
    }
}
