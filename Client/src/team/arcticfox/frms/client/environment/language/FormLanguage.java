package team.arcticfox.frms.client.environment.language;

import com.alibaba.fastjson.annotation.JSONField;

public final class FormLanguage {
    @JSONField(name = "signIn")
    public SignInLanguage signIn;
    @JSONField(name = "register")
    public RegisterLanguage register;
    @JSONField(name = "mainPage")
    public MainPageLanguage mainPage;
    @JSONField(name = "about")
    public AboutLanguage about;
    @JSONField(name = "view")
    public ViewLanguage view;
    @JSONField(name = "cart")
    public CartLanguage cart;


    public FormLanguage(
            SignInLanguage signIn,
            RegisterLanguage register,
            MainPageLanguage mainPage,
            AboutLanguage about,
            ViewLanguage view,
            CartLanguage cart
    ) {
        this.signIn = signIn;
        this.register = register;
        this.mainPage = mainPage;
        this.about = about;
        this.view = view;
        this.cart = cart;
    }
}
