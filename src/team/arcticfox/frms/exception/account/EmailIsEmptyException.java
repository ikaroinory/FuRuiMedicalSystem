package team.arcticfox.frms.exception.account;

import team.arcticfox.frms.exception.FuRuiException;

public final class EmailIsEmptyException extends FuRuiException {
    private static final String CODE = "AC0003";
    private static final String MESSAGE = "Email is empty.";
    private static final String SOLUTION = "Fill in the email and try again.";

    public EmailIsEmptyException() {
        super(CODE, MESSAGE, SOLUTION);
    }
}
