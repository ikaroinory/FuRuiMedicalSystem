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
    public Cart() {
        initComponents();
        EventHandler.initialize(this);
    }

    private void thisWindowClosed(WindowEvent e) {
        Environment.cartForm = null;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPaneCart = new JScrollPane();
        tableCart = new JTable();
        panel1 = new JPanel();
        labelTotalPrice = new JLabel();
        panel2 = new JPanel();
        button1 = new JButton();

        //======== this ========
        setTitle("Cart");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
                    {null, null, null, null},
                },
                new String[] {
                    "Id", "Item Name", "Amount", "Price"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, String.class, Integer.class, Double.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            scrollPaneCart.setViewportView(tableCart);
        }
        contentPane.add(scrollPaneCart, "cell 0 0");

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[150:150,fill]" +
                "[350:350,fill]",
                // rows
                "[41:41,fill]"));

            //---- labelTotalPrice ----
            labelTotalPrice.setText("\uffe5 %total_price%");
            panel1.add(labelTotalPrice, "cell 0 0");

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));

                //---- button1 ----
                button1.setText("Buy");
                panel2.add(button1);
            }
            panel1.add(panel2, "cell 1 0");
        }
        contentPane.add(panel1, "cell 0 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPaneCart;
    JTable tableCart;
    private JPanel panel1;
    JLabel labelTotalPrice;
    private JPanel panel2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
