package team.arcticfox.frms.exception.account;

import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.program.environment.Constant;

public class PasswordIsEmptyException extends FuRuiException {
    private static final String CODE = "AC0002";
    private static final String MESSAGE = "Password is empty.";
    private static final String SOLUTION = "Fill in the password and try again.";

    public PasswordIsEmptyException() {
        super(CODE, MESSAGE, SOLUTION);
    }
}
