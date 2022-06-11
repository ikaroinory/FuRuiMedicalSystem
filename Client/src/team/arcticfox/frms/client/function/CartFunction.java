package team.arcticfox.frms.client.function;

import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.data.ShoppingCart;
import team.arcticfox.frms.utp.CartProtocolClientToServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class CartFunction {
    public static void loading() {
        try {
            Socket socket = new Socket(Environment.config.server.list.cart.ip, Environment.config.server.list.cart.port);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            CartProtocolClientToServer sentObj = new CartProtocolClientToServer(
                    "GET",
                    Environment.accountInfo.id,
                    Environment.accountInfo.username,
                    null
            );

            out.writeUTF(sentObj.toJsonString());
            out.flush();

            Environment.cart = ShoppingCart.parse(in.readUTF());

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        try {
            Socket socket = new Socket(Environment.config.server.list.cart.ip, Environment.config.server.list.cart.port);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            CartProtocolClientToServer sentObj = new CartProtocolClientToServer(
                    "SET",
                    Environment.accountInfo.id,
                    Environment.accountInfo.username,
                    Environment.cart
            );

            out.writeUTF(sentObj.toJsonString());
            out.flush();

            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
