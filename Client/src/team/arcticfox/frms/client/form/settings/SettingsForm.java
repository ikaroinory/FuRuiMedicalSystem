/*
 * Created by JFormDesigner on Sun Jun 12 23:20:48 CST 2022
 */

package team.arcticfox.frms.client.form.settings;

import java.awt.event.*;
import javax.swing.*;

import net.miginfocom.swing.*;

/**
 * @author IkaroInory
 */
public class SettingsForm extends JFrame {
    public SettingsForm() {
        initComponents();
        EventHandler.initialize(this);
    }

    private void buttonApplyActionListener(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        labelLanguage = new JLabel();
        comboBoxLanguage = new JComboBox();
        button1 = new JButton();

        //======== this ========
        setTitle("Settings");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/icons/fr.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[100:100,fill]" +
            "[200:200,fill]",
            // rows
            "[30!,fill]" +
            "[41:41]"));

        //---- labelLanguage ----
        labelLanguage.setText("Language");
        contentPane.add(labelLanguage, "cell 0 0");
        contentPane.add(comboBoxLanguage, "cell 1 0");

        //---- button1 ----
        button1.setText("Apply");
        button1.addActionListener(e -> buttonApplyActionListener(e));
        contentPane.add(button1, "cell 0 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    JLabel labelLanguage;
    JComboBox comboBoxLanguage;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
