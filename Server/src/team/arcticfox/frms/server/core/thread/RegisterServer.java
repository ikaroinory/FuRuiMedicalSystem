package team.arcticfox.frms.server.core.thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.Feature;
import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.exception.NullException;
import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.data.AccountInfo;
import team.arcticfox.frms.data.DateTime;
import team.arcticfox.frms.data.IJsonTextable;
import team.arcticfox.frms.server.environment.Environment;
import team.arcticfox.frms.server.environment.Log;
import team.arcticfox.frms.system.Function;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


class RegisterInfo implements IJsonTextable {
    @JSONField(name = "username")
    public String username;
    @JSONField(name = "email", ordinal = 1)
    public String email;
    @JSONField(name = "password", ordinal = 2)
    public String password;

    RegisterInfo() {
        this("", "", "");
    }

    RegisterInfo(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}


public class RegisterServer extends Thread implements ITerminable {
    private boolean terminated;
    private ServerSocket server;
    private Socket socket;

    public RegisterServer() {
        super();
        terminated = false;
        try {
            server = new ServerSocket(Environment.config.server.list.register.port);
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
            RegisterInfo info = JSON.parseObject(msg, RegisterInfo.class);

            DateTime dateTime = DateTime.now();
            String uuid = Function.getTimeStamp(dateTime);

            Environment.printSession("Register session: " + socket.getRemoteSocketAddress());
            Environment.printSession("Session UUID: " + uuid);

            String exceptionCode = register(info);

            out.writeUTF(exceptionCode);
            out.flush();

            if (exceptionCode.equals(new NullException().code))
                Environment.printSession("Register successful.");
            else
                Environment.printSession("Register failed. " + FuRuiException.parse(exceptionCode).getMessage());

            out.close();
            in.close();
            socket.close();

            Log.createRegisterLog(uuid, dateTime, socket.getRemoteSocketAddress(), exceptionCode, JSON.parseObject(msg, Feature.OrderedField));
        }
    }

    private String register(RegisterInfo info) {
        AccountInfo accountInfo = AccountInfo.getAccountInfo(info.username);
        if (accountInfo != null) return "AC2001";
        Database db = new Database(Environment.config.database.address.ip, Environment.config.database.address.port, Environment.config.database.name);
        db.open(Environment.config.database.root.username, Environment.config.database.root.password);
        db.sqlUpdate(Function.getSQL_Update_AccountInfo_InsertUser(info.username, info.email, info.password));
        db.close();

        return AccountInfo.getAccountInfo(info.username) != null ? "NULL" : "AC2002";
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

    public void terminate() {
        while (socket != null) ;

        terminated = true;
        try {
            Socket temp = new Socket("localhost", Environment.config.server.list.register.port);
            temp.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        end();
    }
}
