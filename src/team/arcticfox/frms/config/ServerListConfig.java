package team.arcticfox.frms.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.data.IJsonTextable;

public final class ServerListConfig implements IJsonTextable {
    @JSONField(name = "sign-in")
    public Address signIn;
    @JSONField(name = "register", ordinal = 1)
    public Address register;
    @JSONField(name = "cart", ordinal = 2)
    public Address cart;
    @JSONField(name = "order", ordinal = 3)
    public Address order;
    @JSONField(name = "chat", ordinal = 4)
    public Address chat;

    public ServerListConfig() {
        this(null, null, null, null, null);
    }
    public ServerListConfig(Address signIn, Address register, Address cart, Address order, Address chat) {
        this.signIn = signIn;
        this.register = register;
        this.cart = cart;
        this.order = order;
        this.chat = chat;
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
