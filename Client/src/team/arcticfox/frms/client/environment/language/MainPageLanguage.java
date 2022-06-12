package team.arcticfox.frms.client.environment.language;

import com.alibaba.fastjson.annotation.JSONField;

public final class MainPageLanguage {
    @JSONField(name = "form-title")
    public String formTitle;
    @JSONField(name = "menu-file")
    public String menuFile;
    @JSONField(name = "menu-account")
    public String menuAccount;
    @JSONField(name = "menu-help")
    public String menuHelp;
    @JSONField(name = "menuItem-settings")
    public String menuItemSettings;
    @JSONField(name = "menuItem-exit")
    public String menuItemExit;
    @JSONField(name = "menuItem-register")
    public String menuItemRegister;
    @JSONField(name = "menuItem-signIn")
    public String menuItemSignIn;
    @JSONField(name = "menuItem-signOut")
    public String menuItemSignOut;
    @JSONField(name = "menuItem-viewCart")
    public String menuItemViewCart;
    @JSONField(name = "menuItem-checkUpdate")
    public String menuItemCheckUpdate;
    @JSONField(name = "menuItem-about")
    public String menuItemAbout;
    @JSONField(name = "tab-welcomePage")
    public String tabWelcomePage;
    @JSONField(name = "tab-medicineList")
    public String tabMedicineList;
    @JSONField(name = "table-id")
    public String tableId;
    @JSONField(name = "table-medicineName")
    public String tableMedicineName;
    @JSONField(name = "table-approvalNo")
    public String tableApprovalNo;
    @JSONField(name = "table-manufacturer")
    public String tableManufacturer;
    @JSONField(name = "table-type")
    public String tableType;
    @JSONField(name = "table-price")
    public String tablePrice;
    @JSONField(name = "table-amount")
    public String tableAmount;
    @JSONField(name = "button-refresh")
    public String buttonRefresh;
    @JSONField(name = "button-viewDetails")
    public String buttonViewDetails;
    @JSONField(name = "button-addToCart")
    public String buttonAddToCart;
    @JSONField(name = "button-viewCart")
    public String buttonViewCart;


    public MainPageLanguage(
            String formTitle,
            String menuFile,
            String menuAccount,
            String menuHelp,
            String menuItemSettings,
            String menuItemExit,
            String menuItemRegister,
            String menuItemSignIn,
            String menuItemSignOut,
            String menuItemViewCart,
            String menuItemCheckUpdate,
            String menuItemAbout,
            String tabWelcomePage,
            String tabMedicineList,
            String tableId,
            String tableMedicineName,
            String tableApprovalNo,
            String tableManufacturer,
            String tableType,
            String tablePrice,
            String tableAmount,
            String buttonRefresh,
            String buttonViewDetails,
            String buttonAddToCart,
            String buttonViewCart
    ) {
        this.formTitle = formTitle;
        this.menuFile = menuFile;
        this.menuAccount = menuAccount;
        this.menuHelp = menuHelp;
        this.menuItemSettings = menuItemSettings;
        this.menuItemExit = menuItemExit;
        this.menuItemRegister = menuItemRegister;
        this.menuItemSignIn = menuItemSignIn;
        this.menuItemSignOut = menuItemSignOut;
        this.menuItemViewCart = menuItemViewCart;
        this.menuItemCheckUpdate = menuItemCheckUpdate;
        this.menuItemAbout = menuItemAbout;
        this.tabWelcomePage = tabWelcomePage;
        this.tabMedicineList = tabMedicineList;
        this.tableId = tableId;
        this.tableMedicineName = tableMedicineName;
        this.tableApprovalNo = tableApprovalNo;
        this.tableManufacturer = tableManufacturer;
        this.tableType = tableType;
        this.tablePrice = tablePrice;
        this.tableAmount = tableAmount;
        this.buttonRefresh = buttonRefresh;
        this.buttonViewDetails = buttonViewDetails;
        this.buttonAddToCart = buttonAddToCart;
        this.buttonViewCart = buttonViewCart;
    }
}
