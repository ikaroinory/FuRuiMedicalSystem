package team.arcticfox.frms.dataset;

import java.util.List;

public class Order {
    List<ShoppingItem> list;

    public Order(List<ShoppingItem> list) {
        this.list = list;
    }

    public double getTotalPrice() {
        double total = 0;
        for (ShoppingItem item : list)
            total += item.getAmount() * item.getUnitPrice();
        return total;
    }
}
