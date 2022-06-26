package team.arcticfox.frms.client.environment.language.message;

import com.alibaba.fastjson.annotation.JSONField;

public class InfoLanguage {
    @JSONField(name = "title")
    public String title;
    @JSONField(name = "sign-in-successful", ordinal = 1)
    public String signInSuccessful;
    @JSONField(name = "sign-in-failed", ordinal = 2)
    public String signInFailed;
    @JSONField(name = "register-successful", ordinal = 3)
    public String registerSuccessful;
    @JSONField(name = "register-failed", ordinal = 4)
    public String registerFailed;
    @JSONField(name = "latest-version", ordinal = 5)
    public String latestVersion;
    @JSONField(name = "order-submitted-successfully", ordinal = 6)
    public String orderSubmittedSuccessfully;

    public InfoLanguage(String title, String signInSuccessful, String signInFailed, String registerSuccessful, String registerFailed, String latestVersion, String orderSubmittedSuccessfully) {
        this.title = title;
        this.signInSuccessful = signInSuccessful;
        this.signInFailed = signInFailed;
        this.registerSuccessful = registerSuccessful;
        this.registerFailed = registerFailed;
        this.latestVersion = latestVersion;
        this.orderSubmittedSuccessfully = orderSubmittedSuccessfully;
    }
}
