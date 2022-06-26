package team.arcticfox.frms.client.environment.language.form;

import com.alibaba.fastjson.annotation.JSONField;

public final class MainPageLanguage {
    @JSONField(name = "form-title")
    public String formTitle;
    @JSONField(name = "menu-file")
    public String menuFile;
    @JSONField(name = "menu-management")
    public String menuManagement;
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
    @JSONField(name = "menuItem-userManagement")
    public String menuItemUserManagement;
    @JSONField(name = "menuItem-medicineManagement")
    public String menuItemMedicineManagement;
    @JSONField(name = "menuItem-onlineService")
    public String menuItemOnlineService;
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
    @JSONField(name = "label-welcome")
    public String labelWelcome;
    @JSONField(name = "label-welcome-page-visit")
    public String labelWelcomePageVisit;
    @JSONField(name = "label-welcome-page")
    public String labelWelcomePage;

    public MainPageLanguage(
            String formTitle,
            String menuFile,
            String menuAccount,
            String menuManagement,
            String menuHelp,
            String menuItemSettings,
            String menuItemExit,
            String menuItemRegister,
            String menuItemSignIn,
            String menuItemSignOut,
            String menuItemViewCart,
            String menuItemUserManagement,
            String menuItemMedicineManagement,
            String menuItemOnlineService,
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
            String buttonViewCart,
            String labelWelcome,
            String labelWelcomePageVisit,
            String labelWelcomePage
    ) {
        this.formTitle = formTitle;
        this.menuFile = menuFile;
        this.menuAccount = menuAccount;
        this.menuManagement = menuManagement;
        this.menuHelp = menuHelp;
        this.menuItemSettings = menuItemSettings;
        this.menuItemExit = menuItemExit;
        this.menuItemRegister = menuItemRegister;
        this.menuItemSignIn = menuItemSignIn;
        this.menuItemSignOut = menuItemSignOut;
        this.menuItemViewCart = menuItemViewCart;
        this.menuItemUserManagement = menuItemUserManagement;
        this.menuItemMedicineManagement = menuItemMedicineManagement;
        this.menuItemOnlineService = menuItemOnlineService;
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
        this.labelWelcome = labelWelcome;
        this.labelWelcomePageVisit = labelWelcomePageVisit;
        this.labelWelcomePage = labelWelcomePage;
    }
}
