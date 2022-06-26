package team.arcticfox.frms.client.environment.language.form;

import com.alibaba.fastjson.annotation.JSONField;

public final class RegisterLanguage {
    @JSONField(name = "form-title")
    public String formTitle;
    @JSONField(name = "label-username")
    public String labelUsername;
    @JSONField(name = "label-email")
    public String labelEmail;
    @JSONField(name = "label-password")
    public String labelPassword;
    @JSONField(name = "label-verifyPassword")
    public String labelVerifyPassword;
    @JSONField(name = "button-register")
    public String buttonRegister;

    public RegisterLanguage(String formTitle, String labelUsername, String labelEmail, String labelPassword, String labelVerifyPassword, String buttonRegister) {
        this.formTitle = formTitle;
        this.labelUsername = labelUsername;
        this.labelEmail = labelEmail;
        this.labelPassword = labelPassword;
        this.labelVerifyPassword = labelVerifyPassword;
        this.buttonRegister = buttonRegister;
    }
}
