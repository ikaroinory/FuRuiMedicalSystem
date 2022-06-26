package team.arcticfox.frms.server.thread;

import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.exception.NullException;
import team.arcticfox.frms.exception.account.PasswordIsWrongException;
import team.arcticfox.frms.exception.account.UserNotFoundException;
import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.data.AccountInfo;
import team.arcticfox.frms.data.DateTime;
import team.arcticfox.frms.server.environment.Environment;
import team.arcticfox.frms.server.environment.Log;
import team.arcticfox.frms.security.MD5;
import team.arcticfox.frms.system.Function;
import team.arcticfox.frms.utp.SignInProtocolClientToServer;
import team.arcticfox.frms.utp.SignInProtocolServerToClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class SignInServer extends ServerThread {
    public SignInServer() {
        super("SignIn Server", Environment.config.server.list.signIn.port);
    }

    private String signIn(String username, String password) {
        AccountInfo accountInfo = AccountInfo.getAccountInfo(username);
        if (accountInfo == null) return new UserNotFoundException().code;
        if (!MD5.encode(password).equals(accountInfo.password)) return new PasswordIsWrongException().code;

        Database db = new Database(Environment.config.database.address.ip, Environment.config.database.address.port, Environment.config.database.name);
        db.open(Environment.config.database.root.username, Environment.config.database.root.password);
        db.sqlUpdate(team.arcticfox.frms.system.Function.getSQL_Update_AccountInfo_UpdateLastLoginTime(accountInfo.id));
        db.close();

        return new NullException().code;
    }

    protected void monitor() {
        while (!terminated) {
            try {
                socket = null;
                socket = server.accept();

                if (terminated) break;

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                SignInProtocolClientToServer receivedObj = SignInProtocolClientToServer.parse(in.readUTF());

                DateTime dateTime = DateTime.now();
                String uuid = Function.getTimeStamp(dateTime);

                Environment.printSession("Login session: " + socket.getRemoteSocketAddress());
                Environment.printSession("Session UUID: " + uuid);

                String exceptionCode = signIn(receivedObj.username, receivedObj.password);

                AccountInfo accountInfo = AccountInfo.getAccountInfo(receivedObj.username);

                SignInProtocolServerToClient sentObj = new SignInProtocolServerToClient(
                        exceptionCode,
                        accountInfo
                );

                out.writeUTF(sentObj.toJsonString());
                out.flush();

                if (exceptionCode.equals(new NullException().code))
                    Environment.printSession("Login successful.");
                else
                    Environment.printSession("Login failed. " + FuRuiException.parse(exceptionCode).getMessage());

                out.close();
                in.close();
                socket.close();

                Log.createSignInServerLog(uuid, dateTime, socket.getRemoteSocketAddress(), exceptionCode, receivedObj.toJsonObject());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
