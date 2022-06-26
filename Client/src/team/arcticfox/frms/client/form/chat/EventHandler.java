package team.arcticfox.frms.client.form.chat;

import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.data.AccountPermission;
import team.arcticfox.frms.data.DateTime;
import team.arcticfox.frms.utp.ChatProtocolClientToServer;

import javax.swing.text.html.HTMLEditorKit;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public final class EventHandler {
    private static void loadLang(Chat chat) {
        chat.setTitle(Environment.language.form.chat.formTitle);

        chat.labelSessionTime.setText(Environment.language.form.chat.labelSessionTime.replaceAll("%now%", DateTime.now().toString()));

        chat.buttonEnd.setText(Environment.language.form.chat.buttonEnd);
        chat.buttonClear.setText(Environment.language.form.chat.buttonClear);
        chat.buttonSend.setText(Environment.language.form.chat.buttonSend);
    }
    static void initialize(Chat chat) {
        loadLang(chat);
        chat.editorPane.setEditorKit(new HTMLEditorKit());

        try {
            if (Environment.accountInfo.permission == AccountPermission.CUSTOMER_SERVICE)
                chat.socket = new Socket(Environment.config.server.list.chat.ip, Environment.config.server.list.chat.port + 2);
            else
                chat.socket = new Socket(Environment.config.server.list.chat.ip, Environment.config.server.list.chat.port);
            chat.out = new DataOutputStream(chat.socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void end(Chat chat) {
        if (chat.socket.isClosed()) return;
        ChatProtocolClientToServer sendObj = new ChatProtocolClientToServer(true, Environment.accountInfo.id, Environment.accountInfo.username, DateTime.now(), "");
        try {
            chat.out.writeUTF(sendObj.toJsonString());
            chat.out.flush();

            chat.out.close();
            chat.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
