package team.arcticfox.frms.data;

import com.alibaba.fastjson.JSONObject;

public interface IJsonTextable {
    JSONObject toJsonObject();
    String toJsonString();
}
