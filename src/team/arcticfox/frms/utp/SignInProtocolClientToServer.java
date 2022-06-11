package team.arcticfox.frms.utp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.data.IJsonTextable;

public class SignInProtocolClientToServer implements IJsonTextable {
    @JSONField(name = "username")
    public String username;
    @JSONField(name = "password", ordinal = 1)
    public String password;


    public SignInProtocolClientToServer() {
        this(null, null);
    }

    public SignInProtocolClientToServer(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public static SignInProtocolClientToServer parse(String s) {
        return JSON.parseObject(s, SignInProtocolClientToServer.class);
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
