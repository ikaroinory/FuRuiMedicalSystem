package team.arcticfox.frms.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class ShoppingCart implements IJsonTextable {
    @JSONField(name = "username")
    public String username;
    @JSONField(name = "list", ordinal = 1, serializeUsing = ShoppingItemSerializer.class, deserializeUsing = ShoppingItemSerializer.class)
    public Map<Integer, ShoppingItem> list;

    public ShoppingCart() {
        this(null, null);
    }
    public ShoppingCart(String username, Map<Integer, ShoppingItem> list) {
        this.username = username;
        this.list = list;
    }

    public static ShoppingCart parse(String json) {
        return JSON.parseObject(json, ShoppingCart.class);
    }

    public void add(ShoppingItem item) {
        if (list == null)
            list = new HashMap<>();

        if (list.containsKey(item.id))
            list.get(item.id).amount += item.amount;
        else
            list.put(item.id, item);
    }
    public void clear() {
        clear(false);
    }
    public void clear(boolean onlySelected) {
        if (list == null) return;

        if (onlySelected) {
            Set<Map.Entry<Integer, ShoppingItem>> itemList = new HashSet<>(list.entrySet());
            for (Map.Entry<Integer, ShoppingItem> item : itemList)
                if (item.getValue().selected)
                    list.remove(item.getKey());
        } else
            list.clear();
    }
    public void selectAll() {
        if (list == null) return;

        for (Map.Entry<Integer, ShoppingItem> item : list.entrySet())
            item.getValue().selected = true;
    }
    public void deselectAll() {
        if (list == null) return;

        for (Map.Entry<Integer, ShoppingItem> item : list.entrySet())
            item.getValue().selected = false;
    }
    public double getTotalPrice() {
        return getTotalPrice(false);
    }
    public double getTotalPrice(boolean onlySelected) {
        if (list == null) return 0;

        BigDecimal price = new BigDecimal(0);
        for (Map.Entry<Integer, ShoppingItem> item : list.entrySet())
            if (!onlySelected || item.getValue().selected)
                price = BigDecimal.valueOf(item.getValue().getTotalPrice()).add(price);

        return price.doubleValue();
    }

    @Override
    public JSONObject toJsonObject() {
        return JSON.parseObject(toJsonString());
    }
    @Override
    public String toJsonString() {
        return JSON.toJSONString(this, true);
    }
}
