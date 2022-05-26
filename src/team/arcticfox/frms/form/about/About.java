/*
 * Created by JFormDesigner on Wed May 25 17:42:16 CST 2022
 */

package team.arcticfox.frms.form.about;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author IkaroInory
 */
public class About extends JDialog {
    public About(Window owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[60:60,fill]" +
            "[350:350,fill]",
            // rows
            "[256:256,top]"));

        //---- label1 ----
        label1.setIcon(new ImageIcon(getClass().getResource("/images/potion 60x60.png")));
        contentPane.add(label1, "cell 0 0");

        //---- label2 ----
        label2.setText("<html>\n    <p><b style=\"color:red\">FuRui Medical System (Internal Development Version)</b></p>\n    <br/>\n    <p>Version: 0.0.2 - alpha</p>\n    <p>\n        MySQL: 8.0<br/>\n        SKD: Java 11.0.12\n    </p>\n    <p>\n        Technical support:<br/>\n         - Aliyun(server support)<br/>\n         - Huaweicloud(network support).\n    </p>\n</html>");
        contentPane.add(label2, "cell 1 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
