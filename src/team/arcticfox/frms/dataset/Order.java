package team.arcticfox.frms.dataset;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.integration.json.JsonParser;

import java.util.List;
import java.util.Random;

public class Order implements JsonParser {
    @JSONField(name = "list")
    private final List<ShoppingItem> list;
    @JSONField(name = "Total Price")
    private double totalPrice;
    // Account Info

    public Order(List<ShoppingItem> list) {
        this.list = list;
        this.totalPrice = 0;
        for (ShoppingItem item : list)
            this.totalPrice += item.getAmount() * item.getUnitPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getOrderNumber() {
        DateTime dateTime = DateTime.now();
        String no = "FR";
        int[] list = {
                dateTime.getMonth(), dateTime.getDay(),
                dateTime.getHour(), dateTime.getMinute(), dateTime.getSecond()
        };
        no += dateTime.getYear();
        for (int i : list) {
            if (i < 10)
                no += '0';
            no += i;
        }
        Random random = new Random(dateTime.timeToLong());
        no += 1000 + random.nextInt() % 9000;
        return no;
    }

    public JSONObject toJsonObject() {
        return JSONObject.parseObject(toString());
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
