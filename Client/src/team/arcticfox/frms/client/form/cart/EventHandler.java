package team.arcticfox.frms.client.form.cart;

import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.data.ShoppingItem;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.Map;

public final class EventHandler {
    static void initialize(Cart cart) {
        cart.tableCart.getTableHeader().setReorderingAllowed(false);
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JTextField.CENTER);
        cart.tableCart.getColumn("Item Name").setCellRenderer(r);
        cart.tableCart.getColumn("Amount").setCellRenderer(r);
        cart.tableCart.getColumn("Price").setCellRenderer(r);

        refresh(cart);
    }

    public static void refresh(Cart cart) {
        ((DefaultTableModel) cart.tableCart.getModel()).getDataVector().clear();
        ((DefaultTableModel) cart.tableCart.getModel()).fireTableDataChanged();
        cart.tableCart.updateUI();

        for (Map.Entry<Integer, ShoppingItem> item : Environment.cart.list.entrySet())
            ((DefaultTableModel) cart.tableCart.getModel()).addRow(item.getValue().toObjectList());

        cart.labelTotalPrice.setText("￥ %total_price%");
        cart.labelTotalPrice.setText(cart.labelTotalPrice.getText().replaceAll("%total_price%", String.valueOf(Environment.cart.getTotalPrice())));
    }
}
