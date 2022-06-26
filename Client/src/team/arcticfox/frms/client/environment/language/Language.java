package team.arcticfox.frms.client.environment.language;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.client.environment.language.exception.ExceptionLanguage;
import team.arcticfox.frms.client.environment.language.form.FormLanguage;
import team.arcticfox.frms.client.environment.language.message.MessageLanguage;

public final class Language {
    @JSONField(name = "form")
    public FormLanguage form;
    @JSONField(name = "message")
    public MessageLanguage message;
    @JSONField(name = "exception")
    public ExceptionLanguage exception;

    public Language(FormLanguage form, MessageLanguage message, ExceptionLanguage exception) {
        this.form = form;
        this.message = message;
        this.exception = exception;
    }

    public static Language parse(String json) {
        return JSON.parseObject(json, Language.class);
    }
}
