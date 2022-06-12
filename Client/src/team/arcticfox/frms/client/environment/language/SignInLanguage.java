package team.arcticfox.frms.client.environment.language;

import com.alibaba.fastjson.annotation.JSONField;

public final class SignInLanguage {
    @JSONField(name = "form-title")
    public String formTitle;
    @JSONField(name = "label-username")
    public String labelUsername;
    @JSONField(name = "label-password")
    public String labelPassword;
    @JSONField(name = "button-signIn")
    public String buttonSignIn;


    public SignInLanguage(String formTitle, String labelUsername, String labelPassword, String buttonSignIn) {
        this.formTitle = formTitle;
        this.labelUsername = labelUsername;
        this.labelPassword = labelPassword;
        this.buttonSignIn = buttonSignIn;
    }
}
