package team.arcticfox.frms.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.data.IJsonTextable;

public class ServerListConfig implements IJsonTextable {
    @JSONField(name = "sign-in")
    public Address signIn;
    @JSONField(name = "register", ordinal = 1)
    public Address register;
    @JSONField(name = "cart", ordinal = 2)
    public Address cart;


    public ServerListConfig() {
        this(null, null, null);
    }

    public ServerListConfig(Address signIn, Address register, Address cart) {
        this.signIn = signIn;
        this.register = register;
        this.cart = cart;
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
