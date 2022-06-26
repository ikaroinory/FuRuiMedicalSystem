package team.arcticfox.frms.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.system.Function;
import team.arcticfox.frms.utp.OrderProtocolClientToServer;

import java.util.List;

public final class Order implements IJsonTextable {
    @JSONField(name = "uuid")
    public String uuid;
    @JSONField(name = "id", ordinal = 5)
    public int id;
    @JSONField(name = "username", ordinal = 10)
    public String username;
    @JSONField(name = "time", ordinal = 15, serializeUsing = DateTimeSerializer.class, deserializeUsing = DateTimeSerializer.class)
    public DateTime time;
    @JSONField(name = "list", ordinal = 20)
    public List<ShoppingItem> list;
    @JSONField(name = "total-price", ordinal = 25)
    public double totalPrice;

    public Order() {
        this(null, 0, null, null, null, 0);
    }
    public Order(String uuid, int id, String username, DateTime time, List<ShoppingItem> list, double totalPrice) {
        this.uuid = uuid;
        this.id = id;
        this.username = username;
        this.time = time;
        this.list = list;
        this.totalPrice = totalPrice;
    }

    public static Order parse(String json) {
        return JSON.parseObject(json, Order.class);
    }
    public static Order parse(OrderProtocolClientToServer utpObj) {
        DateTime now = DateTime.now();
        return new Order(
                "FR" + Function.getTimeStamp(now),
                utpObj.id,
                utpObj.username,
                now,
                utpObj.list,
                utpObj.totalPrice
        );
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
