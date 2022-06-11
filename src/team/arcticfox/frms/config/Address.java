package team.arcticfox.frms.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.data.IJsonTextable;

public class Address implements IJsonTextable {
    @JSONField(name = "ip")
    public String ip;
    @JSONField(name = "port", ordinal = 1)
    public int port;


    public Address() {
        this(null, 0);
    }

    public Address(String ip, int port) {
        this.ip = ip;
        this.port = port;
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
