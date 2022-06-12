package team.arcticfox.frms.utp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.data.AccountInfo;
import team.arcticfox.frms.data.IJsonTextable;

public final class SignInProtocolServerToClient implements IJsonTextable {
    @JSONField(name = "code")
    public String code;
    @JSONField(name = "account-info", ordinal = 1)
    public AccountInfo accountInfo;


    public SignInProtocolServerToClient() {
        this(null, null);
    }

    public SignInProtocolServerToClient(String code, AccountInfo accountInfo) {
        this.code = code;
        this.accountInfo = accountInfo;
    }


    public static SignInProtocolServerToClient parse(String s) {
        return JSON.parseObject(s, SignInProtocolServerToClient.class);
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
