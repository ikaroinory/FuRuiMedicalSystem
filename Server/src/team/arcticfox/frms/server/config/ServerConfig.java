package team.arcticfox.frms.server.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.config.Address;
import team.arcticfox.frms.config.DatabaseConfig;
import team.arcticfox.frms.data.IJsonTextable;

public class ServerConfig implements IJsonTextable {
    @JSONField(name = "name")
    public String name;
    @JSONField(name = "uuid", ordinal = 1)
    public String uuid;
    @JSONField(name = "address", ordinal = 2)
    public Address address;
    @JSONField(name = "list", ordinal = 3)
    public ServerListConfig list;
    @JSONField(name = "database", ordinal = 4)
    public DatabaseConfig database;


    public ServerConfig(String name, String uuid, Address address, ServerListConfig list, DatabaseConfig database) {
        this.name = name;
        this.uuid = uuid;
        this.address = address;
        this.list = list;
        this.database = database;
    }


    @Override
    public String toJsonString() {
        return JSON.toJSONString(this, true);
    }
}
