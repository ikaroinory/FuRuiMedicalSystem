package team.arcticfox.frms.client.form.chat;

import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.data.AccountPermission;
import team.arcticfox.frms.system.SystemEnvironment;
import team.arcticfox.frms.utp.ChatProtocolClientToServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

final class ReceiveThread extends Thread {
    private Chat chat;
    private Socket socket;
    private DataInputStream in;

    ReceiveThread(Chat chat) {
        this.chat = chat;
        this.socket = null;
        this.in = null;
    }

    private void monitor() throws IOException {
        if (Environment.accountInfo.permission == AccountPermission.CUSTOMER_SERVICE)
            socket = new Socket(Environment.config.server.list.chat.ip, Environment.config.server.list.chat.port + 1);
        else
            socket = new Socket(Environment.config.server.list.chat.ip, Environment.config.server.list.chat.port + 3);
        in = new DataInputStream(socket.getInputStream());

        while (true) {
            ChatProtocolClientToServer receivedObj = ChatProtocolClientToServer.parse(in.readUTF());
            if (receivedObj.terminated) {
                /*
                chat.editorPane.setText(
                        chat.editorPane.getText() +
                                "-------------------------------------------------------------------------------------------" + SystemEnvironment.EOL +
                                Environment.language.form.chat.msgSessionEnded + SystemEnvironment.EOL
                );
                 */
                chat.history += "<hr />" +
                        "<span color=\"red\", style=\"font-weight: bold\">" + Environment.language.form.chat.msgSessionEnded + "</span>" +
                        "<br />";
                chat.editorPane.setText(chat.history);
                chat.buttonEnd.setEnabled(false);
                chat.buttonSend.setEnabled(false);
                EventHandler.end(chat);
                break;
            }

            /*
            chat.editorPane.setText(
                    chat.editorPane.getText() +
                            receivedObj.username + "(" + receivedObj.id + ") " + receivedObj.time + ":" + SystemEnvironment.EOL +
                            receivedObj.message + SystemEnvironment.EOL +
                            SystemEnvironment.EOL
            );
             */
            chat.history += "<span color=\"blue\", style=\"font-weight: bold\">" + receivedObj.username + "(" + receivedObj.id + ") " + receivedObj.time + "</span>" + "<br />" +
                    "<span>" + receivedObj.message.replaceAll("\n", "<br />") + "</span>" + "<br />" +
                    "<br />";
            chat.editorPane.setText(chat.history);
        }
    }

    @Override
    public void run() {
        try {
            monitor();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
