package team.arcticfox.frms.server.thread;

import team.arcticfox.frms.server.environment.Environment;
import team.arcticfox.frms.utp.ChatProtocolClientToServer;

import java.io.DataInputStream;
import java.io.IOException;

public final class ServiceToServerChatServer extends ServerThread implements ITerminable {
    public ServiceToServerChatServer() {
        super("Service To Server Chat Server", Environment.config.server.list.chat.port + 2);
    }

    @Override
    protected void monitor() {
        while (!terminated) {
            try {
                socket = null;
                socket = server.accept();

                if (terminated) break;

                DataInputStream in = new DataInputStream(socket.getInputStream());

                while (true) {
                    ChatProtocolClientToServer receivedObj = ChatProtocolClientToServer.parse(in.readUTF());
                    System.out.println("Service to Server:" + receivedObj.toJsonString());

                    Environment.serverToUserChatServer.messageQueue.offer(receivedObj);

                    if (receivedObj.terminated) {
                        Environment.serverToUserChatServer.chatTerminated = true;
                        break;
                    }
                }

                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
