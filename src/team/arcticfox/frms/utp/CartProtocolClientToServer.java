package team.arcticfox.frms.utp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.data.IJsonTextable;
import team.arcticfox.frms.data.ShoppingCart;

public final class CartProtocolClientToServer implements IJsonTextable {
    @JSONField(name = "command")
    public String command;
    @JSONField(name = "id", ordinal = 1)
    public int id;
    @JSONField(name = "username", ordinal = 2)
    public String username;
    @JSONField(name = "cart", ordinal = 3)
    public ShoppingCart cart;


    public CartProtocolClientToServer() {
        this(null, 0, null, null);
    }

    public CartProtocolClientToServer(String command, int id, String username, ShoppingCart cart) {
        this.command = command;
        this.id = id;
        this.username = username;
        this.cart = cart;
    }


    public static CartProtocolClientToServer parse(String json) {
        return JSON.parseObject(json, CartProtocolClientToServer.class);
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
