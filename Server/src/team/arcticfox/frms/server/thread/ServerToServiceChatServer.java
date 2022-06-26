package team.arcticfox.frms.server.thread;

import team.arcticfox.frms.server.environment.Environment;
import team.arcticfox.frms.utp.ChatProtocolClientToServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public final class ServerToServiceChatServer extends ServerThread implements ITerminable {
    public boolean chatTerminated;
    public Queue<ChatProtocolClientToServer> messageQueue;

    public ServerToServiceChatServer() {
        super("Server To Service Chat Server", Environment.config.server.list.chat.port + 1);
        chatTerminated = false;
        messageQueue = new LinkedList<>();
    }

    @Override
    protected void monitor() {
        while (!terminated) {
            try {
                socket = null;
                socket = server.accept();

                if (terminated) break;

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                while (!chatTerminated) {
                    while (!messageQueue.isEmpty()) {
                        out.writeUTF(messageQueue.poll().toJsonString());
                        out.flush();
                    }
                }

                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
