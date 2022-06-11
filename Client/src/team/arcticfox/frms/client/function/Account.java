package team.arcticfox.frms.client.function;

import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.exception.NullException;
import team.arcticfox.frms.exception.account.*;
import team.arcticfox.frms.utp.RegisterProtocolClientToServer;
import team.arcticfox.frms.utp.SignInProtocolClientToServer;
import team.arcticfox.frms.utp.SignInProtocolServerToClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.regex.Pattern;

public final class Account {
    private static boolean isNotComplex(String password) {
        String pattern = "^.*(?=.{8,16})(?=.*\\d)(?=.*[A-Z]+)(?=.*[a-z]+)(?=.*[!@#$%^&*?()]).*$";
        return !Pattern.matches(pattern, password);
    }

    public static boolean signIn(String username, String password) throws FuRuiException {
        if (username.equals("")) throw new UsernameIsEmptyException();
        if (password.equals("")) throw new PasswordIsEmptyException();

        SignInProtocolClientToServer sentObj = new SignInProtocolClientToServer(username, password);
        SignInProtocolServerToClient receivedObj = null;
        try {
            Socket socket = new Socket(Environment.config.server.list.signIn.ip, Environment.config.server.list.signIn.port);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            out.writeUTF(sentObj.toJsonString());
            receivedObj = SignInProtocolServerToClient.parse(in.readUTF());

            Environment.accountInfo = receivedObj.accountInfo;

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!receivedObj.code.equals(new NullException().code)) throw FuRuiException.parse(receivedObj.code);

        CartFunction.loading();

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

        RegisterProtocolClientToServer sentObj = new RegisterProtocolClientToServer(username, email, password);
        String receivedObj = "";
        try {
            Socket socket = new Socket(Environment.config.server.list.register.ip, Environment.config.server.list.register.port);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            out.writeUTF(sentObj.toJsonString());
            receivedObj = in.readUTF();

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!receivedObj.equals(new NullException().code)) throw FuRuiException.parse(receivedObj);

        return true;
    }
}
