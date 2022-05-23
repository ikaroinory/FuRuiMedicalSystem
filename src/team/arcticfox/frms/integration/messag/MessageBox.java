package team.arcticfox.frms.integration.messag;

import javax.swing.*;

public class MessageBox {
    public static void show(String message) {
        JOptionPane.showMessageDialog(null, message, null, JOptionPane.PLAIN_MESSAGE);
    }

    public static void show(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    public static void show(String title, String message, int icon) {
        JOptionPane.showMessageDialog(null, message, title, icon);
    }
}
