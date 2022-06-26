package team.arcticfox.frms.client.environment.language.form;

import com.alibaba.fastjson.annotation.JSONField;

public class ChatLanguage {
    @JSONField(name = "form-title")
    public String formTitle;
    @JSONField(name = "label-sessionTime")
    public String labelSessionTime;
    @JSONField(name = "button-end")
    public String buttonEnd;
    @JSONField(name = "button-clear")
    public String buttonClear;
    @JSONField(name = "button-send")
    public String buttonSend;
    @JSONField(name = "msg-sessionEnded")
    public String msgSessionEnded;

    public ChatLanguage(String formTitle, String labelSessionTime, String buttonEnd, String buttonClear, String buttonSend, String msgSessionEnded) {
        this.formTitle = formTitle;
        this.labelSessionTime = labelSessionTime;
        this.buttonEnd = buttonEnd;
        this.buttonClear = buttonClear;
        this.buttonSend = buttonSend;
        this.msgSessionEnded = msgSessionEnded;
    }
}
