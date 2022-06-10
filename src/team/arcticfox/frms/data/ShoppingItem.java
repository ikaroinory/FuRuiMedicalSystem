package team.arcticfox.frms.data;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.integration.json.JsonParser;

public class ShoppingItem implements JsonParser {
    @JSONField(name = "Id")
    private final int id;
    @JSONField(name = "Amount")
    private final int amount;
    @JSONField(name = "Unit Price")
    private final double unitPrice;

    public ShoppingItem(int id, int amount, int unitPrice) {
        this.id = id;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public JSONObject toJsonObject() {
        return JSONObject.parseObject(toString());
    }

    @Override
    public String toString() {
        // return "{\"Shopping Cart\": {\"id\": " + id + ", \"amount\": " + amount + "}}";
        return JSONObject.toJSONString(this);
    }
}
