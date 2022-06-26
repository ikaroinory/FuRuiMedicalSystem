package team.arcticfox.frms.client.environment.language.message;

import com.alibaba.fastjson.annotation.JSONField;

public class WarningLanguage {
    @JSONField(name = "title")
    public String title;
    @JSONField(name = "select-at-least-one-item", ordinal = 1)
    public String selectAtLeastOneItem;

    public WarningLanguage(String title, String selectAtLeastOneItem) {
        this.title = title;
        this.selectAtLeastOneItem = selectAtLeastOneItem;
    }
}
