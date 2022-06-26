package team.arcticfox.frms.utp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.data.IJsonTextable;
import team.arcticfox.frms.data.ShoppingItem;

import java.util.List;

public final class OrderProtocolClientToServer implements IJsonTextable {
    @JSONField(name = "id", ordinal = 5)
    public int id;
    @JSONField(name = "username", ordinal = 10)
    public String username;
    @JSONField(name = "list", ordinal = 20)
    public List<ShoppingItem> list;
    @JSONField(name = "total-price", ordinal = 25)
    public double totalPrice;

    public OrderProtocolClientToServer() {
        this(0, null, null, 0);
    }
    public OrderProtocolClientToServer(int id, String username, List<ShoppingItem> list, double totalPrice) {
        this.id = id;
        this.username = username;
        this.list = list;
        this.totalPrice = totalPrice;
    }

    public static OrderProtocolClientToServer parse(String json) {
        return JSON.parseObject(json, OrderProtocolClientToServer.class);
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
