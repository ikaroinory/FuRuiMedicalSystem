/*
 * Created by JFormDesigner on Sun May 22 18:04:33 CST 2022
 */

package team.arcticfox.frms.form.signin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.miginfocom.swing.*;

/**
 * @author IkaroInory
 */
public class SignIn extends JFrame {
    public SignIn() {
        initComponents();
    }

    private void buttonSignInActionListener(ActionEvent e) {
        EventHandler.signIn(
                textFieldUsername.getText(),
                String.valueOf(passwordFieldPassword.getPassword())
        );
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panelAccount = new JPanel();
        labelUsername = new JLabel();
        textFieldUsername = new JTextField();
        labelPassword = new JLabel();
        passwordFieldPassword = new JPasswordField();
        panelButton = new JPanel();
        buttonSignIn = new JButton();

        //======== this ========
        setVisible(true);
        setMinimumSize(new Dimension(350, 182));
        setResizable(false);
        setTitle("Sign In");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[320:320,fill]",
                // rows
                "[81:81,fill]" +
                        "[41:41,fill]"));

        //======== panelAccount ========
        {
            panelAccount.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[100:100,fill]" +
                            "[199:199,fill]",
                    // rows
                    "[30:30,fill]" +
                            "[30:30,fill]"));

            //---- labelUsername ----
            labelUsername.setText("Username");
            panelAccount.add(labelUsername, "cell 0 0");
            panelAccount.add(textFieldUsername, "cell 1 0");

            //---- labelPassword ----
            labelPassword.setText("Password");
            panelAccount.add(labelPassword, "cell 0 1");
            panelAccount.add(passwordFieldPassword, "cell 1 1");
        }
        contentPane.add(panelAccount, "cell 0 0");

        //======== panelButton ========
        {
            panelButton.setLayout(new FlowLayout());

            //---- buttonSignIn ----
            buttonSignIn.setText("Sign In");
            buttonSignIn.addActionListener(e -> buttonSignInActionListener(e));
            panelButton.add(buttonSignIn);
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
    private JLabel labelPassword;
    private JPasswordField passwordFieldPassword;
    private JPanel panelButton;
    private JButton buttonSignIn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
