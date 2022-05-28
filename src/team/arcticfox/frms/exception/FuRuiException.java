package team.arcticfox.frms.exception;

import team.arcticfox.frms.integration.message.IDisplayable;
import team.arcticfox.frms.integration.message.MessageBox;
import team.arcticfox.frms.program.environment.Constant;

public class FuRuiException extends Exception implements IDisplayable {
    public final String code;
    public final String solution;

    protected FuRuiException(String code, String message, String solution) {
        super(message);
        this.code = code;
        this.solution = solution;
    }

    @Override
    public void displayMessageBox() {
        String displayMessage = "Code: " + code + Constant.ENDL
                + Constant.ENDL
                + "Information: " + getMessage() + Constant.ENDL
                + Constant.ENDL
                + "Solution: " + solution + Constant.ENDL;
        MessageBox.show(MessageBox.Title.ERROR.getTitle() + " " + code, displayMessage, MessageBox.Icon.ERROR);
    }
}
