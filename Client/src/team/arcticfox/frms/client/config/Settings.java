package team.arcticfox.frms.client.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.data.IJsonTextable;

public final class Settings implements IJsonTextable {
    @JSONField(name = "language")
    public String language;


    public Settings() {
        this(null);
    }

    public Settings(String language) {
        this.language = language;
    }


    public static Settings parse(String json) {
        return JSON.parseObject(json, Settings.class);
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
