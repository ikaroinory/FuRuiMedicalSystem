package team.arcticfox.frms.client.environment.language.form;

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
    @JSONField(name = "chat")
    public ChatLanguage chat;

    public FormLanguage(SignInLanguage signIn, RegisterLanguage register, MainPageLanguage mainPage, AboutLanguage about, ViewLanguage view, CartLanguage cart, ChatLanguage chat) {
        this.signIn = signIn;
        this.register = register;
        this.mainPage = mainPage;
        this.about = about;
        this.view = view;
        this.cart = cart;
        this.chat = chat;
    }
}
