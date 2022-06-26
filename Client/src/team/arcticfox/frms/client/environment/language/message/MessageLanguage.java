package team.arcticfox.frms.client.environment.language.message;

import com.alibaba.fastjson.annotation.JSONField;

public class MessageLanguage {
    @JSONField(name = "info")
    public InfoLanguage info;
    @JSONField(name = "warning")
    public WarningLanguage warning;
    @JSONField(name = "error")
    public ErrorLanguage error;

    public MessageLanguage(InfoLanguage info, WarningLanguage warning, ErrorLanguage error) {
        this.info = info;
        this.warning = warning;
        this.error = error;
    }
}
