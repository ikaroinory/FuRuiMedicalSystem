/*
 * Created by JFormDesigner on Sun Jun 05 15:48:39 CST 2022
 */

package team.arcticfox.frms.client.form.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.miginfocom.swing.*;
import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.data.MedicineInfo;

/**
 * @author IkaroInory
 */
public class View extends JFrame {

    private final MedicineInfo medicineInfo;

    public View(int id) {
        initComponents();

        medicineInfo = EventHandler.initialize(this, id);
    }

    private void buttonCopyMedicineNameActionListener(ActionEvent e) {
        Environment.copyToClipboard(labelMedicineName.getText());
    }

    private void buttonCopyApprovalNoActionListener(ActionEvent e) {
        Environment.copyToClipboard(labelApprovalNo.getText());
    }

    private void buttonCopyTypeActionListener(ActionEvent e) {
        Environment.copyToClipboard(labelType.getText());
    }

    private void buttonCopySpecificationActionListener(ActionEvent e) {
        Environment.copyToClipboard(labelSpecification.getText());
    }

    private void buttonCopyManufacturerActionListener(ActionEvent e) {
        Environment.copyToClipboard(labelManufacturer.getText());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        labelImage = new JLabel();
        panelMainInfo = new JPanel();
        labelGrade = new JLabel();
        labelMedicineName = new JLabel();
        buttonCopyMedicineName = new JButton();
        labelPrice = new JLabel();
        panelInformation = new JPanel();
        labelApprovalNoLabel = new JLabel();
        labelApprovalNo = new JLabel();
        buttonCopyApprovalNo = new JButton();
        labelTypeLabel = new JLabel();
        labelType = new JLabel();
        buttonCopyType = new JButton();
        labelSpecificationLabel = new JLabel();
        labelSpecification = new JLabel();
        buttonCopySpecification = new JButton();
        labelManufacturerLabel = new JLabel();
        labelManufacturer = new JLabel();
        buttonCopyManufacturer = new JButton();
        panelButton = new JPanel();
        buttonAddToCart = new JButton();

        //======== this ========
        setTitle("%medicine_name% - View");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(551, 564));
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[521:521,center]",
            // rows
            "[250:250,center]" +
            "[44!,fill]" +
            "[155!,fill]" +
            "[41:41,fill]"));

        //---- labelImage ----
        labelImage.setIcon(new ImageIcon(getClass().getResource("/images/default.jpeg")));
        contentPane.add(labelImage, "cell 0 0");

        //======== panelMainInfo ========
        {
            panelMainInfo.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[70!,fill]" +
                "[313!,fill]" +
                "[30!,fill]" +
                "[73!,fill]",
                // rows
                "[30:30,fill]"));

            //---- labelGrade ----
            labelGrade.setText("%grade%");
            labelGrade.setForeground(Color.red);
            panelMainInfo.add(labelGrade, "cell 0 0");

            //---- labelMedicineName ----
            labelMedicineName.setText("%medicine_name%");
            panelMainInfo.add(labelMedicineName, "cell 1 0");

            //---- buttonCopyMedicineName ----
            buttonCopyMedicineName.setMaximumSize(new Dimension(30, 30));
            buttonCopyMedicineName.setMinimumSize(new Dimension(30, 30));
            buttonCopyMedicineName.setPreferredSize(new Dimension(30, 30));
            buttonCopyMedicineName.addActionListener(e -> buttonCopyMedicineNameActionListener(e));
            panelMainInfo.add(buttonCopyMedicineName, "cell 2 0");

            //---- labelPrice ----
            labelPrice.setText("\uffe5 %price%");
            panelMainInfo.add(labelPrice, "cell 3 0");
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

            //---- buttonCopyApprovalNo ----
            buttonCopyApprovalNo.setMaximumSize(new Dimension(30, 30));
            buttonCopyApprovalNo.setMinimumSize(new Dimension(30, 30));
            buttonCopyApprovalNo.setPreferredSize(new Dimension(30, 30));
            buttonCopyApprovalNo.addActionListener(e -> buttonCopyApprovalNoActionListener(e));
            panelInformation.add(buttonCopyApprovalNo, "cell 2 0");

            //---- labelTypeLabel ----
            labelTypeLabel.setText("Type");
            panelInformation.add(labelTypeLabel, "cell 0 1");

            //---- labelType ----
            labelType.setText("%type%");
            panelInformation.add(labelType, "cell 1 1");

            //---- buttonCopyType ----
            buttonCopyType.setMaximumSize(new Dimension(30, 30));
            buttonCopyType.setMinimumSize(new Dimension(30, 30));
            buttonCopyType.setPreferredSize(new Dimension(30, 30));
            buttonCopyType.addActionListener(e -> buttonCopyTypeActionListener(e));
            panelInformation.add(buttonCopyType, "cell 2 1");

            //---- labelSpecificationLabel ----
            labelSpecificationLabel.setText("Specification");
            panelInformation.add(labelSpecificationLabel, "cell 0 2");

            //---- labelSpecification ----
            labelSpecification.setText("%specification%");
            panelInformation.add(labelSpecification, "cell 1 2");

            //---- buttonCopySpecification ----
            buttonCopySpecification.setMinimumSize(new Dimension(30, 30));
            buttonCopySpecification.setPreferredSize(new Dimension(30, 30));
            buttonCopySpecification.setMaximumSize(new Dimension(30, 30));
            buttonCopySpecification.addActionListener(e -> buttonCopySpecificationActionListener(e));
            panelInformation.add(buttonCopySpecification, "cell 2 2");

            //---- labelManufacturerLabel ----
            labelManufacturerLabel.setText("Manufacturer");
            panelInformation.add(labelManufacturerLabel, "cell 0 3");

            //---- labelManufacturer ----
            labelManufacturer.setText("%manufacturer%");
            panelInformation.add(labelManufacturer, "cell 1 3");

            //---- buttonCopyManufacturer ----
            buttonCopyManufacturer.setMinimumSize(new Dimension(30, 30));
            buttonCopyManufacturer.setPreferredSize(new Dimension(30, 30));
            buttonCopyManufacturer.setMaximumSize(new Dimension(30, 30));
            buttonCopyManufacturer.addActionListener(e -> buttonCopyManufacturerActionListener(e));
            panelInformation.add(buttonCopyManufacturer, "cell 2 3");
        }
        contentPane.add(panelInformation, "cell 0 2");

        //======== panelButton ========
        {
            panelButton.setLayout(new FlowLayout());

            //---- buttonAddToCart ----
            buttonAddToCart.setText("Add To Cart");
            panelButton.add(buttonAddToCart);
        }
        contentPane.add(panelButton, "cell 0 3");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    JLabel labelImage;
    private JPanel panelMainInfo;
    JLabel labelGrade;
    JLabel labelMedicineName;
    JButton buttonCopyMedicineName;
    JLabel labelPrice;
    private JPanel panelInformation;
    private JLabel labelApprovalNoLabel;
    JLabel labelApprovalNo;
    JButton buttonCopyApprovalNo;
    private JLabel labelTypeLabel;
    JLabel labelType;
    JButton buttonCopyType;
    private JLabel labelSpecificationLabel;
    JLabel labelSpecification;
    JButton buttonCopySpecification;
    private JLabel labelManufacturerLabel;
    JLabel labelManufacturer;
    JButton buttonCopyManufacturer;
    private JPanel panelButton;
    private JButton buttonAddToCart;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
