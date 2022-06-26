package team.arcticfox.frms.client.environment.language.form;

import com.alibaba.fastjson.annotation.JSONField;

public final class ViewLanguage {
    @JSONField(name = "form-title")
    public String formTitle;
    @JSONField(name = "label-id")
    public String labelId;
    @JSONField(name = "label-approvalNo")
    public String labelApprovalNo;
    @JSONField(name = "label-type")
    public String labelType;
    @JSONField(name = "label-specification")
    public String labelSpecification;
    @JSONField(name = "label-manufacturer")
    public String labelManufacturer;
    @JSONField(name = "button-addToCart")
    public String buttonAddToCart;

    public ViewLanguage(String formTitle, String labelId, String labelApprovalNo, String labelType, String labelSpecification, String labelManufacturer, String buttonAddToCart) {
        this.formTitle = formTitle;
        this.labelId = labelId;
        this.labelApprovalNo = labelApprovalNo;
        this.labelType = labelType;
        this.labelSpecification = labelSpecification;
        this.labelManufacturer = labelManufacturer;
        this.buttonAddToCart = buttonAddToCart;
    }
}
