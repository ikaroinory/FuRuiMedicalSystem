package team.arcticfox.frms.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.data.IJsonTextable;

public final class UserPwdPair implements IJsonTextable {
    @JSONField(name = "username")
    public String username;
    @JSONField(name = "password", ordinal = 1)
    public String password;

    public UserPwdPair() {
        this(null, null);
    }
    public UserPwdPair(String username, String password) {
        this.username = username;
        this.password = password;
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
