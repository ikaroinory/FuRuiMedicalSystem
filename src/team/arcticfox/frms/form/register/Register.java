/*
 * Created by JFormDesigner on Sun May 22 18:39:34 CST 2022
 */

package team.arcticfox.frms.form.register;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.miginfocom.swing.*;

/**
 * @author IkaroInory
 */
public class Register extends JFrame {
    public Register() {
        initComponents();
    }

    private void buttonRegisterActionListener(ActionEvent e) {
        EventHandler.register(
                textFieldUsername.getText(),
                textFieldEmail.getText(),
                String.valueOf(passwordFieldPassword.getPassword()),
                String.valueOf(passwordFieldVerificationPassword.getPassword())
        );
    }

    private void buttonRegisterKeyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER)
            buttonRegisterActionListener(null);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panelAccount = new JPanel();
        labelUsername = new JLabel();
        textFieldUsername = new JTextField();
        labelEmail = new JLabel();
        textFieldEmail = new JTextField();
        labelPassword = new JLabel();
        passwordFieldPassword = new JPasswordField();
        labelVerificationPassword = new JLabel();
        passwordFieldVerificationPassword = new JPasswordField();
        panelButton = new JPanel();
        buttonRegister = new JButton();

        //======== this ========
        setTitle("Register");
        setVisible(true);
        setMinimumSize(new Dimension(370, 256));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[320:340,fill]",
            // rows
            "[155:155,fill]" +
            "[41:41,fill]"));

        //======== panelAccount ========
        {
            panelAccount.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[100:120,fill]" +
                "[199:199,fill]",
                // rows
                "[30:30,fill]" +
                "[30:30,fill]" +
                "[30:30,fill]" +
                "[30:30,fill]"));

            //---- labelUsername ----
            labelUsername.setText("Username");
            panelAccount.add(labelUsername, "cell 0 0");
            panelAccount.add(textFieldUsername, "cell 1 0");

            //---- labelEmail ----
            labelEmail.setText("Email");
            panelAccount.add(labelEmail, "cell 0 1");
            panelAccount.add(textFieldEmail, "cell 1 1");

            //---- labelPassword ----
            labelPassword.setText("Password");
            panelAccount.add(labelPassword, "cell 0 2");
            panelAccount.add(passwordFieldPassword, "cell 1 2");

            //---- labelVerificationPassword ----
            labelVerificationPassword.setText("Verify Password");
            panelAccount.add(labelVerificationPassword, "cell 0 3");

            //---- passwordFieldVerificationPassword ----
            passwordFieldVerificationPassword.setNextFocusableComponent(buttonRegister);
            panelAccount.add(passwordFieldVerificationPassword, "cell 1 3");
        }
        contentPane.add(panelAccount, "cell 0 0");

        //======== panelButton ========
        {
            panelButton.setLayout(new FlowLayout());

            //---- buttonRegister ----
            buttonRegister.setText("Register");
            buttonRegister.addActionListener(e -> buttonRegisterActionListener(e));
            buttonRegister.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    buttonRegisterKeyPressed(e);
                }
            });
            panelButton.add(buttonRegister);
        }
        contentPane.add(panelButton, "cell 0 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panelAccount;
    private JLabel labelUsername;
    private JTextField textFieldUsername;
    private JLabel labelEmail;
    private JTextField textFieldEmail;
    private JLabel labelPassword;
    private JPasswordField passwordFieldPassword;
    private JLabel labelVerificationPassword;
    private JPasswordField passwordFieldVerificationPassword;
    private JPanel panelButton;
    private JButton buttonRegister;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
