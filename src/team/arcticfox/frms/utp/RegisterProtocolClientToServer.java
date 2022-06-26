package team.arcticfox.frms.utp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.data.IJsonTextable;

public final class RegisterProtocolClientToServer implements IJsonTextable {
    @JSONField(name = "username")
    public String username;
    @JSONField(name = "email", ordinal = 1)
    public String email;
    @JSONField(name = "password", ordinal = 2)
    public String password;


    public RegisterProtocolClientToServer() {
        this(null, null, null);
    }
    public RegisterProtocolClientToServer(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static RegisterProtocolClientToServer parse(String s) {
        return JSON.parseObject(s, RegisterProtocolClientToServer.class);
    }

    @Override
    public JSONObject toJsonObject() {
        return JSON.parseObject(toJsonString());
    }
    @Override
    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}
