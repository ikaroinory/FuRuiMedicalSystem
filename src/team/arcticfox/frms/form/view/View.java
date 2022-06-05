/*
 * Created by JFormDesigner on Sun Jun 05 15:48:39 CST 2022
 */

package team.arcticfox.frms.form.view;

import javax.swing.*;

import net.miginfocom.swing.*;

/**
 * @author IkaroInory
 */
public class View extends JFrame {
    public View() {
        initComponents();

        EventHandler.initialize(this);
    }

    public View(int id) {
        initComponents();

        EventHandler.initialize(this, id);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        labelImage = new JLabel();
        panelMainInfo = new JPanel();
        labelGrade = new JLabel();
        labelMedicineName = new JLabel();
        labelPrice = new JLabel();
        panelInformation = new JPanel();
        labelApprovalNoLabel = new JLabel();
        labelApprovalNo = new JLabel();
        labelTypeLabel = new JLabel();
        labelType = new JLabel();
        labelSpecificationLabel = new JLabel();
        labelSpecification = new JLabel();
        labelManufacturerLabel = new JLabel();
        labelManufacturer = new JLabel();

        //======== this ========
        setTitle("View");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[521:521,center]",
            // rows
            "[250:250,center]" +
            "[44!,fill]" +
            "[155!,fill]"));

        //---- labelImage ----
        labelImage.setIcon(new ImageIcon(getClass().getResource("/images/potion 60x60.png")));
        contentPane.add(labelImage, "cell 0 0");

        //======== panelMainInfo ========
        {
            panelMainInfo.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[70!,fill]" +
                "[350!,fill]" +
                "[73!,fill]",
                // rows
                "[30:30,fill]"));

            //---- labelGrade ----
            labelGrade.setText("%grade%");
            panelMainInfo.add(labelGrade, "cell 0 0");

            //---- labelMedicineName ----
            labelMedicineName.setText("%medicine_name%");
            panelMainInfo.add(labelMedicineName, "cell 1 0");

            //---- labelPrice ----
            labelPrice.setText("\uffe5 %price%");
            panelMainInfo.add(labelPrice, "cell 2 0");
        }
        contentPane.add(panelMainInfo, "cell 0 1");

        //======== panelInformation ========
        {
            panelInformation.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[150:150,fill]" +
                "[313:313,fill]" +
                "[30:30,fill]",
                // rows
                "[30:30,fill]" +
                "[30:30,fill]" +
                "[30:30,fill]" +
                "[30:30,fill]"));

            //---- labelApprovalNoLabel ----
            labelApprovalNoLabel.setText("Approval No");
            panelInformation.add(labelApprovalNoLabel, "cell 0 0");

            //---- labelApprovalNo ----
            labelApprovalNo.setText("%approval_no%");
            panelInformation.add(labelApprovalNo, "cell 1 0");

            //---- labelTypeLabel ----
            labelTypeLabel.setText("Type");
            panelInformation.add(labelTypeLabel, "cell 0 1");

            //---- labelType ----
            labelType.setText("%type%");
            panelInformation.add(labelType, "cell 1 1");

            //---- labelSpecificationLabel ----
            labelSpecificationLabel.setText("Specification");
            panelInformation.add(labelSpecificationLabel, "cell 0 2");

            //---- labelSpecification ----
            labelSpecification.setText("%specification%");
            panelInformation.add(labelSpecification, "cell 1 2");

            //---- labelManufacturerLabel ----
            labelManufacturerLabel.setText("Manufacturer");
            panelInformation.add(labelManufacturerLabel, "cell 0 3");

            //---- labelManufacturer ----
            labelManufacturer.setText("%manufacturer%");
            panelInformation.add(labelManufacturer, "cell 1 3");
        }
        contentPane.add(panelInformation, "cell 0 2");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    JLabel labelImage;
    private JPanel panelMainInfo;
    JLabel labelGrade;
    JLabel labelMedicineName;
    JLabel labelPrice;
    private JPanel panelInformation;
    private JLabel labelApprovalNoLabel;
    JLabel labelApprovalNo;
    private JLabel labelTypeLabel;
    JLabel labelType;
    private JLabel labelSpecificationLabel;
    JLabel labelSpecification;
    private JLabel labelManufacturerLabel;
    JLabel labelManufacturer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
