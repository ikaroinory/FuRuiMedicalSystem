package team.arcticfox.frms.client.environment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.client.environment.language.FormLanguage;

public final class Language {
    @JSONField(name = "form")
    public FormLanguage form;

    public Language(FormLanguage form) {
        this.form = form;
    }


    public static Language parse(String json) {
        return JSON.parseObject(json, Language.class);
    }
}
