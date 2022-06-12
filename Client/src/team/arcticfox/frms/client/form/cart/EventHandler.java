package team.arcticfox.frms.client.form.cart;

import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.client.function.CartFunction;
import team.arcticfox.frms.data.ShoppingItem;
import team.arcticfox.frms.integration.message.MessageBox;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class EventHandler {
    public static final int INDEX_SELECTED = 0;
    public static final int INDEX_ID = 1;
    public static final int INDEX_NAME = 2;
    public static final int INDEX_AMOUNT = 3;
    public static final int INDEX_PRICE = 4;

    private static void loadLang(Cart cart) {
        cart.setTitle(Environment.language.form.cart.formTitle);

        //

        cart.radioButtonSelectAll.setText(Environment.language.form.cart.radioButtonSelectAll);
        cart.buttonClear.setText(Environment.language.form.cart.buttonClear);
        cart.buttonBuy.setText(Environment.language.form.cart.buttonBuy);
    }

    private static void refreshOthers(Cart cart) {
        cart.labelTotalPrice.setText("￥ %total_price%");
        cart.labelTotalPrice.setText(cart.labelTotalPrice.getText().replaceAll("%total_price%", String.valueOf(Environment.cart.getTotalPrice(true))));

        cart.radioButtonSelectAll.setSelected(cart.selectedCount == cart.totalCount);
    }

    static void initialize(Cart cart) {
        loadLang(cart);

        cart.tableCart.getTableHeader().setReorderingAllowed(false);
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JTextField.CENTER);
        cart.tableCart.getColumn("Id").setCellRenderer(r);
        cart.tableCart.getColumn("Amount").setCellRenderer(r);
        cart.tableCart.getColumn("Price").setCellRenderer(r);

        refresh(cart);

        cart.tableCart.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getLastRow();
                    if (e.getColumn() == INDEX_SELECTED) {
                        int id = (int) cart.tableCart.getValueAt(row, INDEX_ID);
                        boolean selected = (boolean) cart.tableCart.getValueAt(row, INDEX_SELECTED);

                        Environment.cart.list.get(id).selected = selected;

                        cart.selectedCount += selected ? 1 : -1;
                    }
                    if (e.getColumn() == INDEX_AMOUNT) {
                        int id = (int) cart.tableCart.getValueAt(row, INDEX_ID);
                        int amount = (int) cart.tableCart.getValueAt(row, INDEX_AMOUNT);

                        Environment.cart.list.get(id).amount = amount;

                        cart.tableCart.setValueAt(Environment.cart.list.get(id).getTotalPrice(), row, INDEX_PRICE);
                    }
                    refreshOthers(cart);
                }
            }
        });
    }

    static void buy(Cart cart) {
        List<ShoppingItem> list = new ArrayList<>();
        BigDecimal totalPrice = new BigDecimal(0);

        int rowCount = cart.tableCart.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            boolean selected = (boolean) cart.tableCart.getValueAt(i, INDEX_SELECTED);
            if (!selected) continue;

            int id = (int) cart.tableCart.getValueAt(i, INDEX_ID);
            list.add(Environment.cart.list.get(id));
            totalPrice = new BigDecimal(Environment.cart.list.get(id).getTotalPrice()).add(totalPrice);
        }
        if (list.isEmpty())
            MessageBox.show(MessageBox.Title.WARNING, "Select at least one item!", MessageBox.Icon.WARNING);
        else {
            CartFunction.buy(list, totalPrice.doubleValue());
            update(cart);
            Environment.cart.clear(true);
            refresh(cart);
        }
    }

    // return selected all
    public static void refresh(Cart cart) {
        cart.totalCount = 0;
        cart.selectedCount = 0;

        ((DefaultTableModel) cart.tableCart.getModel()).getDataVector().clear();
        ((DefaultTableModel) cart.tableCart.getModel()).fireTableDataChanged();
        cart.tableCart.updateUI();

        for (Map.Entry<Integer, ShoppingItem> item : Environment.cart.list.entrySet()) {
            cart.totalCount++;

            Object[] list = item.getValue().toObjectList();
            ((DefaultTableModel) cart.tableCart.getModel()).addRow(list);

            cart.selectedCount += (boolean) list[0] ? 1 : 0;
        }

        cart.tableCart.getColumnModel().getColumn(1).setHeaderValue(Environment.language.form.cart.tableId);
        cart.tableCart.getColumnModel().getColumn(2).setHeaderValue(Environment.language.form.cart.tableItemName);
        cart.tableCart.getColumnModel().getColumn(3).setHeaderValue(Environment.language.form.cart.tableAmount);
        cart.tableCart.getColumnModel().getColumn(4).setHeaderValue(Environment.language.form.cart.tablePrice);

        refreshOthers(cart);
    }

    public static void update(Cart cart) {
        int rowCount = cart.tableCart.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            boolean selected = (boolean) cart.tableCart.getValueAt(i, INDEX_SELECTED);
            int id = (int) cart.tableCart.getValueAt(i, INDEX_ID);
            int amount = (int) cart.tableCart.getValueAt(i, INDEX_AMOUNT);

            Environment.cart.list.get(id).selected = selected;
            Environment.cart.list.get(id).amount = amount;
        }
    }
}
