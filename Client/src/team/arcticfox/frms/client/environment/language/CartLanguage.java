package team.arcticfox.frms.client.environment.language;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public final class CartLanguage {
    @JSONField(name = "form-title")
    public String formTitle;
    @JSONField(name = "table-id", ordinal = 5)
    public String tableId;
    @JSONField(name = "table-itemName", ordinal = 10)
    public String tableItemName;
    @JSONField(name = "table-amount", ordinal = 15)
    public String tableAmount;
    @JSONField(name = "table-price", ordinal = 20)
    public String tablePrice;
    @JSONField(name = "radioButton-selectAll", ordinal = 25)
    public String radioButtonSelectAll;
    @JSONField(name = "button-clear", ordinal = 30)
    public String buttonClear;
    @JSONField(name = "button-buy", ordinal = 35)
    public String buttonBuy;


    public CartLanguage(
            String formTitle,
            String tableId,
            String tableItemName,
            String tableAmount,
            String tablePrice,
            String radioButtonSelectAll,
            String buttonClear,
            String buttonBuy
    ) {
        this.formTitle = formTitle;
        this.tableId = tableId;
        this.tableItemName = tableItemName;
        this.tableAmount = tableAmount;
        this.tablePrice = tablePrice;
        this.radioButtonSelectAll = radioButtonSelectAll;
        this.buttonClear = buttonClear;
        this.buttonBuy = buttonBuy;
    }
}
