package team.arcticfox.frms.client.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.config.DatabaseConfig;
import team.arcticfox.frms.data.IJsonTextable;

public class Config implements IJsonTextable {
    @JSONField(name = "version")
    public String version;
    @JSONField(name = "database", ordinal = 1)
    public DatabaseConfig database;


    public Config(String version, DatabaseConfig database) {
        this.version = version;
        this.database = database;
    }


    @Override
    public String toJsonString() {
        return JSON.toJSONString(this, true);
    }
}
