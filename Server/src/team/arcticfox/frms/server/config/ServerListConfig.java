package team.arcticfox.frms.server.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.config.Address;
import team.arcticfox.frms.data.IJsonTextable;

public class ServerListConfig implements IJsonTextable {
    @JSONField(name = "sign-in")
    public Address signIn;
    @JSONField(name = "register")
    public Address register;


    public ServerListConfig(Address signIn, Address register) {
        this.signIn = signIn;
        this.register = register;
    }


    @Override
    public String toJsonString() {
        return JSON.toJSONString(this, true);
    }
}
