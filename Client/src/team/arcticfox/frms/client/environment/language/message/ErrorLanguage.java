package team.arcticfox.frms.client.environment.language.message;

import com.alibaba.fastjson.annotation.JSONField;

public class ErrorLanguage {
    @JSONField(name = "title")
    public String title;
    @JSONField(name = "select-a-row", ordinal = 1)
    public String selectARow;

    public ErrorLanguage(String title, String selectARow) {
        this.title = title;
        this.selectARow = selectARow;
    }
}
