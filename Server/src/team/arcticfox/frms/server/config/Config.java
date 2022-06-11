package team.arcticfox.frms.server.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.config.DatabaseConfig;
import team.arcticfox.frms.config.ServerConfig;
import team.arcticfox.frms.data.IJsonTextable;

public class Config implements IJsonTextable {
    @JSONField(name = "version")
    public String version;
    @JSONField(name = "server", ordinal = 1)
    public ServerConfig server;
    @JSONField(name = "database", ordinal = 2)
    public DatabaseConfig database;

    public Config() {
        this(null, null, null);
    }

    public Config(String version, ServerConfig server, DatabaseConfig database) {
        this.version = version;
        this.server = server;
        this.database = database;
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
