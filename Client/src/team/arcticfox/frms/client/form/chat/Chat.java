/*
 * Created by JFormDesigner on Fri Jun 24 21:04:36 CST 2022
 */

package team.arcticfox.frms.client.form.chat;

import java.awt.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.*;

import net.miginfocom.swing.*;
import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.data.DateTime;
import team.arcticfox.frms.system.SystemEnvironment;
import team.arcticfox.frms.utp.ChatProtocolClientToServer;

/**
 * @author IkaroInory
 */
public class Chat extends JFrame {
    String history;
    Socket socket;
    DataOutputStream out;
    public Chat() {
        initComponents();
        EventHandler.initialize(this);
        (new ReceiveThread(this)).start();
        history = "";
    }

    private void thisWindowClosed(WindowEvent e) {
        buttonEndActionListener(null);
        Environment.chatForm = null;
    }

    private void buttonSendActionListener(ActionEvent e) {
        String msg = textArea.getText();
        if (msg.equals("")) return;

        textArea.setText("");

        ChatProtocolClientToServer sendObj = new ChatProtocolClientToServer(false, Environment.accountInfo.id, Environment.accountInfo.username, DateTime.now(), msg);
        /*
        editorPane.setText(
                editorPane.getText() +
                        sendObj.username + "(" + sendObj.id + ") " + sendObj.time + ":" + SystemEnvironment.EOL +
                        sendObj.message + SystemEnvironment.EOL +
                        SystemEnvironment.EOL
        );
         */
        history += "<span color=\"green\", style=\"font-weight: bold\">" + sendObj.username + "(" + sendObj.id + ") " + sendObj.time + "</span>" + "<br />" +
                "<span>" + sendObj.message.replaceAll("\n", "<br />") + "</span>" + "<br />" +
                "<br />";
        editorPane.setText(history);

        try {
            out.writeUTF(sendObj.toJsonString());
            out.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void buttonEndActionListener(ActionEvent e) {
        EventHandler.end(this);
        this.dispose();
    }

    private void buttonClearActionListener(ActionEvent e) {
        history = "";
        editorPane.setText(history);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panelTitle = new JPanel();
        labelSessionTime = new JLabel();
        panelEnd = new JPanel();
        buttonEnd = new JButton();
        scrollPaneShow = new JScrollPane();
        editorPane = new JEditorPane();
        scrollPaneSend = new JScrollPane();
        textArea = new JTextArea();
        panelButton = new JPanel();
        buttonClear = new JButton();
        buttonSend = new JButton();

        //======== this ========
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chat");
        setIconImage(new ImageIcon(getClass().getResource("/icons/fr.png")).getImage());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                thisWindowClosed(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[521:521,fill]",
            // rows
            "[55:55,fill]" +
            "[400:400,fill]" +
            "[100:100,fill]" +
            "[41:41]"));

        //======== panelTitle ========
        {
            panelTitle.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[400:400,fill]" +
                "[100:100,fill]",
                // rows
                "[41:41,fill]"));

            //---- labelSessionTime ----
            labelSessionTime.setText("Session Time: %now%");
            panelTitle.add(labelSessionTime, "cell 0 0");

            //======== panelEnd ========
            {
                panelEnd.setLayout(new FlowLayout());

                //---- buttonEnd ----
                buttonEnd.setText("End");
                buttonEnd.addActionListener(e -> buttonEndActionListener(e));
                panelEnd.add(buttonEnd);
            }
            panelTitle.add(panelEnd, "cell 1 0");
        }
        contentPane.add(panelTitle, "cell 0 0");

        //======== scrollPaneShow ========
        {

            //---- editorPane ----
            editorPane.setEditable(false);
            scrollPaneShow.setViewportView(editorPane);
        }
        contentPane.add(scrollPaneShow, "cell 0 1");

        //======== scrollPaneSend ========
        {
            scrollPaneSend.setViewportView(textArea);
        }
        contentPane.add(scrollPaneSend, "cell 0 2");

        //======== panelButton ========
        {
            panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));

            //---- buttonClear ----
            buttonClear.setText("Clear");
            buttonClear.addActionListener(e -> buttonClearActionListener(e));
            panelButton.add(buttonClear);

            //---- buttonSend ----
            buttonSend.setText("Send");
            buttonSend.addActionListener(e -> buttonSendActionListener(e));
            panelButton.add(buttonSend);
        }
        contentPane.add(panelButton, "cell 0 3");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panelTitle;
    JLabel labelSessionTime;
    private JPanel panelEnd;
    JButton buttonEnd;
    private JScrollPane scrollPaneShow;
    JEditorPane editorPane;
    private JScrollPane scrollPaneSend;
    JTextArea textArea;
    private JPanel panelButton;
    JButton buttonClear;
    JButton buttonSend;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
