/*
 * Created by JFormDesigner on Wed May 25 17:42:16 CST 2022
 */

package team.arcticfox.frms.client.form.about;

import java.awt.*;
import javax.swing.*;

import net.miginfocom.swing.*;
import team.arcticfox.frms.client.environment.Environment;

/**
 * @author IkaroInory
 */
public class About extends JDialog {
    public About(Window owner) {
        super(owner);
        initComponents();
        initialize();
        loadLang();
    }


    private void loadLang() {
        setTitle(Environment.language.form.about.formTitle);
        labelAboutInfo.setText(labelAboutInfo.getText().replaceAll("%version%", Environment.config.version));
    }

    private void initialize() {
        ImageIcon iconImage = new ImageIcon(getClass().getResource("/icons/fr.png"));
        iconImage.setImage(iconImage.getImage().getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING));
        labelImage.setIcon(iconImage);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        labelImage = new JLabel();
        labelAboutInfo = new JLabel();

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

        //---- labelImage ----
        labelImage.setIcon(new ImageIcon(getClass().getResource("/icons/fr.png")));
        contentPane.add(labelImage, "cell 0 0");

        //---- labelAboutInfo ----
        labelAboutInfo.setText("<html>\n    <p><b style=\"color:red\">FuRui Medical System (Education Edition)</b></p>\n    <br/>\n    <p>Version: %version%</p>\n    <p>\n        MySQL: 8.0<br/>\n        SKD: Java 11.0.12\n    </p>\n    <p>\n        Technical support:<br/>\n         - Aliyun(server support)<br/>\n         - Huaweicloud(network support).\n    </p>\n</html>");
        contentPane.add(labelAboutInfo, "cell 1 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel labelImage;
    private JLabel labelAboutInfo;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
