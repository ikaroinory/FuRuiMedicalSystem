package team.arcticfox.frms.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public double getTotalPrice() {
        if (list == null) return 0;

        double price = 0;
        for (Map.Entry<Integer, ShoppingItem> item : list.entrySet())
            price += item.getValue().price * item.getValue().amount;
        return price;
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
