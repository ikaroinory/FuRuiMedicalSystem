/*
 * Created by JFormDesigner on Sat Jun 11 17:50:00 CST 2022
 */

package team.arcticfox.frms.client.form.cart;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import net.miginfocom.swing.*;
import team.arcticfox.frms.client.environment.Environment;

/**
 * @author IkaroInory
 */
public class Cart extends JFrame {
    int selectedCount = 0;
    int totalCount = 0;


    public Cart() {
        initComponents();
        EventHandler.initialize(this);
    }

    private void thisWindowClosed(WindowEvent e) {
        EventHandler.update(this);
        Environment.cartForm = null;
    }

    private void buttonClearActionListener(ActionEvent e) {
        EventHandler.update(this);
        Environment.cart.clear(true);
        EventHandler.refresh(this);
    }

    private void buttonBuyActionListener(ActionEvent e) {
        EventHandler.buy(this);
    }

    private void radioButtonSelectAllActionEvent(ActionEvent e) {
        if (radioButtonSelectAll.isSelected()) {
            Environment.cart.selectAll();
            EventHandler.refresh(this);
        } else {
            Environment.cart.deselectAll();
            EventHandler.refresh(this);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPaneCart = new JScrollPane();
        tableCart = new JTable();
        panelFunction = new JPanel();
        radioButtonSelectAll = new JRadioButton();
        labelTotalPrice = new JLabel();
        panelButton = new JPanel();
        buttonClear = new JButton();
        buttonBuy = new JButton();

        //======== this ========
        setTitle("Cart");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/icons/fr.png")).getImage());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                thisWindowClosed(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[521:521,fill]",
            // rows
            "[493:493,fill]" +
            "[55:55,fill]"));

        //======== scrollPaneCart ========
        {

            //---- tableCart ----
            tableCart.setModel(new DefaultTableModel(
                new Object[][] {
                    {false, null, null, null, null},
                },
                new String[] {
                    "\u221a", "Id", "Item Name", "Amount", "Price"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Boolean.class, Integer.class, String.class, Integer.class, Double.class
                };
                boolean[] columnEditable = new boolean[] {
                    true, false, false, true, false
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = tableCart.getColumnModel();
                cm.getColumn(0).setResizable(false);
                cm.getColumn(0).setMinWidth(25);
                cm.getColumn(0).setMaxWidth(25);
                cm.getColumn(0).setPreferredWidth(25);
                cm.getColumn(1).setResizable(false);
                cm.getColumn(1).setMinWidth(45);
                cm.getColumn(1).setMaxWidth(45);
                cm.getColumn(1).setPreferredWidth(45);
                cm.getColumn(2).setResizable(false);
                cm.getColumn(3).setResizable(false);
                cm.getColumn(3).setMinWidth(100);
                cm.getColumn(3).setMaxWidth(100);
                cm.getColumn(3).setPreferredWidth(100);
                cm.getColumn(4).setResizable(false);
                cm.getColumn(4).setMinWidth(100);
                cm.getColumn(4).setMaxWidth(100);
                cm.getColumn(4).setPreferredWidth(100);
            }
            scrollPaneCart.setViewportView(tableCart);
        }
        contentPane.add(scrollPaneCart, "cell 0 0");

        //======== panelFunction ========
        {
            panelFunction.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[93:93,fill]" +
                "[100:100,fill]" +
                "[300:300,fill]",
                // rows
                "[41:41,fill]"));

            //---- radioButtonSelectAll ----
            radioButtonSelectAll.setText("Select All");
            radioButtonSelectAll.addActionListener(e -> radioButtonSelectAllActionEvent(e));
            panelFunction.add(radioButtonSelectAll, "cell 0 0");

            //---- labelTotalPrice ----
            labelTotalPrice.setText("\uffe5 %total_price%");
            panelFunction.add(labelTotalPrice, "cell 1 0");

            //======== panelButton ========
            {
                panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));

                //---- buttonClear ----
                buttonClear.setText("Clear");
                buttonClear.addActionListener(e -> buttonClearActionListener(e));
                panelButton.add(buttonClear);

                //---- buttonBuy ----
                buttonBuy.setText("Buy");
                buttonBuy.addActionListener(e -> buttonBuyActionListener(e));
                panelButton.add(buttonBuy);
            }
            panelFunction.add(panelButton, "cell 2 0");
        }
        contentPane.add(panelFunction, "cell 0 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPaneCart;
    JTable tableCart;
    private JPanel panelFunction;
    JRadioButton radioButtonSelectAll;
    JLabel labelTotalPrice;
    private JPanel panelButton;
    JButton buttonClear;
    JButton buttonBuy;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
