package team.arcticfox.frms.server.thread;

import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.exception.NullException;
import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.data.AccountInfo;
import team.arcticfox.frms.data.DateTime;
import team.arcticfox.frms.server.environment.Environment;
import team.arcticfox.frms.server.environment.Log;
import team.arcticfox.frms.system.Function;
import team.arcticfox.frms.utp.RegisterProtocolClientToServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public final class RegisterServer extends ServerThread {
    public RegisterServer() {
        super(Environment.config.server.list.register.port);
    }


    protected void monitor() {
        while (!terminated) {
            try {
                socket = null;
                socket = server.accept();

                if (terminated) break;

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // String msg = in.readUTF();
                RegisterProtocolClientToServer receivedObj = RegisterProtocolClientToServer.parse(in.readUTF());

                DateTime dateTime = DateTime.now();
                String uuid = Function.getTimeStamp(dateTime);

                Environment.printSession("Register session: " + socket.getRemoteSocketAddress());
                Environment.printSession("Session UUID: " + uuid);

                String exceptionCode = register(receivedObj);

                out.writeUTF(exceptionCode);
                out.flush();

                if (exceptionCode.equals(new NullException().code))
                    Environment.printSession("Register successful.");
                else
                    Environment.printSession("Register failed. " + FuRuiException.parse(exceptionCode).getMessage());

                out.close();
                in.close();
                socket.close();

                Log.createRegisterLog(uuid, dateTime, socket.getRemoteSocketAddress(), exceptionCode, receivedObj.toJsonObject());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String register(RegisterProtocolClientToServer info) {
        AccountInfo accountInfo = AccountInfo.getAccountInfo(info.username);
        if (accountInfo != null) return "AC2001";
        Database db = new Database(Environment.config.database.address.ip, Environment.config.database.address.port, Environment.config.database.name);
        db.open(Environment.config.database.root.username, Environment.config.database.root.password);
        db.sqlUpdate(Function.getSQL_Update_AccountInfo_InsertUser(info.username, info.email, info.password));
        db.close();

        return AccountInfo.getAccountInfo(info.username) != null ? "NULL" : "AC2002";
    }
}
