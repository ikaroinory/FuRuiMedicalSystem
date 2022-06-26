package team.arcticfox.frms.utp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.data.DateTime;
import team.arcticfox.frms.data.DateTimeSerializer;
import team.arcticfox.frms.data.IJsonTextable;

public final class ChatProtocolClientToServer implements IJsonTextable {
    @JSONField(name = "terminated")
    public boolean terminated;
    @JSONField(name = "id")
    public int id;
    @JSONField(name = "username")
    public String username;
    @JSONField(name = "time", serializeUsing = DateTimeSerializer.class, deserializeUsing = DateTimeSerializer.class)
    public DateTime time;
    @JSONField(name = "message")
    public String message;

    public ChatProtocolClientToServer() {
        this(false, 0, null, null, null);
    }
    public ChatProtocolClientToServer(boolean terminated, int id, String username, DateTime time, String message) {
        this.terminated = terminated;
        this.id = id;
        this.username = username;
        this.time = time;
        this.message = message;
    }

    public static ChatProtocolClientToServer parse(String json) {
        return JSON.parseObject(json, ChatProtocolClientToServer.class);
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
