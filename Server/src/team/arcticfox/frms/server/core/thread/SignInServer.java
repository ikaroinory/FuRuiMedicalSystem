package team.arcticfox.frms.server.core.thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.Feature;
import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.exception.NullException;
import team.arcticfox.frms.exception.account.PasswordIsWrongException;
import team.arcticfox.frms.exception.account.UserNotFoundException;
import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.data.AccountInfo;
import team.arcticfox.frms.data.DateTime;
import team.arcticfox.frms.data.IJsonTextable;
import team.arcticfox.frms.server.environment.Environment;
import team.arcticfox.frms.server.environment.Log;
import team.arcticfox.frms.security.MD5;
import team.arcticfox.frms.system.Function;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


class SignInInfo implements IJsonTextable {
    @JSONField(name = "username")
    public String username;
    @JSONField(name = "password", ordinal = 1)
    public String password;

    SignInInfo() {
        this("", "");
    }

    SignInInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}


public class SignInServer extends Thread implements ITerminable {
    private boolean terminated;
    private ServerSocket server;
    private Socket socket;

    public SignInServer() {
        super();
        terminated = false;
        try {
            server = new ServerSocket(Environment.config.server.list.signIn.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void end() {
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void monitor() throws IOException {
        while (!terminated) {
            socket = null;
            socket = server.accept();

            if (terminated) break;

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String msg = in.readUTF();
            SignInInfo info = JSON.parseObject(msg, SignInInfo.class);

            DateTime dateTime = DateTime.now();
            String uuid = Function.getTimeStamp(dateTime);

            Environment.printSession("Login session: " + socket.getRemoteSocketAddress());
            Environment.printSession("Session UUID: " + uuid);

            String exceptionCode = signIn(info.username, info.password);

            out.writeUTF(exceptionCode);
            out.flush();

            AccountInfo accountInfo = AccountInfo.getAccountInfo(info.username);
            if (accountInfo == null)
                out.writeUTF("");
            else
                out.writeUTF(AccountInfo.getAccountInfo(info.username).toJsonString());
            out.flush();

            if (exceptionCode.equals(new NullException().code))
                Environment.printSession("Login successful.");
            else
                Environment.printSession("Login failed. " + FuRuiException.parse(exceptionCode).getMessage());

            out.close();
            in.close();
            socket.close();

            Log.createSignInServerLog(uuid, dateTime, socket.getRemoteSocketAddress(), exceptionCode, JSON.parseObject(msg, Feature.OrderedField));
        }
    }

    private String signIn(String username, String password) {
        AccountInfo accountInfo = AccountInfo.getAccountInfo(username);
        if (accountInfo == null) return new UserNotFoundException().code;
        if (!MD5.encode(password).equals(accountInfo.password)) return new PasswordIsWrongException().code;

        Database db = new Database();
        db.open();
        db.sqlUpdate(team.arcticfox.frms.system.Function.getSQL_Update_AccountInfo_UpdateLastLoginTime(accountInfo.id));
        db.close();

        return new NullException().code;
    }

    @Override
    public void run() {
        try {
            monitor();
        } catch (IOException e) {
            // Do nothing.
        }
        end();
    }

    @Override
    public void terminate() {
        while (socket!=null);

        terminated=true;
        try {
            Socket temp = new Socket("localhost", Environment.config.server.list.signIn.port);
            temp.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        end();
    }
}
