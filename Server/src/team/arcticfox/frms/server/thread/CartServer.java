package team.arcticfox.frms.server.thread;

import team.arcticfox.frms.data.ShoppingCart;
import team.arcticfox.frms.server.environment.Environment;
import team.arcticfox.frms.system.Function;
import team.arcticfox.frms.utp.CartProtocolClientToServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public final class CartServer extends ServerThread {
    public CartServer() {
        super(Environment.config.server.list.cart.port);
    }

    protected void monitor() {
        while (!terminated) {
            try {
                socket = null;
                socket = server.accept();

                if (terminated) break;

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // The command that sent by client.
                CartProtocolClientToServer receiveObj = CartProtocolClientToServer.parse(in.readUTF());

                Environment.printSession("Cart session: " + socket.getRemoteSocketAddress());
                Environment.printSession("Session UUID: " + Function.getTimeStamp());


                if (receiveObj.command.equals("GET")) {
                    Environment.printSession("Get...");

                    String json = Function.readFile(Environment.DIR_CARTS + receiveObj.id + ".json");
                    if (json.equals(""))
                        out.writeUTF(new ShoppingCart(receiveObj.username, new HashMap<>()).toJsonString());
                    else
                        out.writeUTF(json);
                    out.flush();
                }
                if (receiveObj.command.equals("SET")) {
                    FileOutputStream fout = new FileOutputStream(Environment.DIR_CARTS + receiveObj.id + ".json");

                    fout.write(receiveObj.cart.toJsonString().getBytes(StandardCharsets.UTF_8));
                    fout.flush();

                    Environment.printSession("Set...");

                    fout.close();
                }

                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
