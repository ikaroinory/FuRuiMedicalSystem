package team.arcticfox.frms.client.environment.language;

import com.alibaba.fastjson.annotation.JSONField;

public final class AboutLanguage {
    @JSONField(name = "form-title")
    public String formTitle;


    public AboutLanguage(String formTitle) {
        this.formTitle = formTitle;
    }
}
