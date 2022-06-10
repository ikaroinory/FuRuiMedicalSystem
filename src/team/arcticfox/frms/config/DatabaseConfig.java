package team.arcticfox.frms.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.data.IJsonTextable;

public class DatabaseConfig implements IJsonTextable {
    @JSONField(name = "name")
    public String name;
    @JSONField(name = "address", ordinal = 1)
    public Address address;
    @JSONField(name = "root", ordinal = 2)
    public UserPwdPair root;


    public DatabaseConfig(String name, Address address, UserPwdPair root) {
        this.name = name;
        this.address = address;
        this.root = root;
    }


    @Override
    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}