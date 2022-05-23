/*
 * Created by JFormDesigner on Sun May 22 18:39:34 CST 2022
 */

package team.arcticfox.frms.form.register;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author IkaroInory
 */
public class Register extends JFrame {
    public Register() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        label4 = new JLabel();
        passwordField2 = new JPasswordField();
        panel2 = new JPanel();
        button1 = new JButton();

        //======== this ========
        setTitle("Register");
        setVisible(true);
        setMinimumSize(new Dimension(370, 256));
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[320:340,fill]",
            // rows
            "[155:155,fill]" +
            "[41:41,fill]"));

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[100:120,fill]" +
                "[199:199,fill]",
                // rows
                "[30:30,fill]" +
                "[30:30,fill]" +
                "[30:30,fill]" +
                "[30:30,fill]"));

            //---- label1 ----
            label1.setText("Username");
            panel1.add(label1, "cell 0 0");
            panel1.add(textField1, "cell 1 0");

            //---- label2 ----
            label2.setText("Email");
            panel1.add(label2, "cell 0 1");
            panel1.add(textField2, "cell 1 1");

            //---- label3 ----
            label3.setText("Password");
            panel1.add(label3, "cell 0 2");
            panel1.add(passwordField1, "cell 1 2");

            //---- label4 ----
            label4.setText("Verify Password");
            panel1.add(label4, "cell 0 3");
            panel1.add(passwordField2, "cell 1 3");
        }
        contentPane.add(panel1, "cell 0 0");

        //======== panel2 ========
        {
            panel2.setLayout(new FlowLayout());

            //---- button1 ----
            button1.setText("Register");
            panel2.add(button1);
        }
        contentPane.add(panel2, "cell 0 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JLabel label4;
    private JPasswordField passwordField2;
    private JPanel panel2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
