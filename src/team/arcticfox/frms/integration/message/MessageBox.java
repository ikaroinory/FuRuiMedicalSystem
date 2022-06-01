package team.arcticfox.frms.integration.message;

import javax.swing.*;

public class MessageBox {
    public enum Title {
        INFORMATION("Information"),
        WARNING("Warning"),
        ERROR("Error");

        private final String title;

        Title(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public enum Icon {
        NONE(JOptionPane.PLAIN_MESSAGE),
        INFORMATION(JOptionPane.INFORMATION_MESSAGE),
        QUESTION(JOptionPane.QUESTION_MESSAGE),
        WARNING(JOptionPane.WARNING_MESSAGE),
        ERROR(JOptionPane.ERROR_MESSAGE);

        private final int icon;

        Icon(int icon) {
            this.icon = icon;
        }

        public int getIcon() {
            return icon;
        }
    }

    public static void show(String message) {
        JOptionPane.showMessageDialog(null, message, null, JOptionPane.PLAIN_MESSAGE);
    }

    public static void show(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    public static void show(String title, String message, int icon) {
        JOptionPane.showMessageDialog(null, message, title, icon);
    }

    public static void show(String title, String message, Icon icon) {
        JOptionPane.showMessageDialog(null, message, title, icon.getIcon());
    }

    public static void show(Title title, String message, Icon icon) {
        JOptionPane.showMessageDialog(null, message, title.getTitle(), icon.getIcon());
    }
}
