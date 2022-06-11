package team.arcticfox.frms.exception.account;

import team.arcticfox.frms.exception.FuRuiException;

public final class DifferentPasswordException extends FuRuiException {
    private static final String CODE = "AC0005";
    private static final String MESSAGE = "The two password is different.";
    private static final String SOLUTION = "Check whether the two passwords are the same, and try again.";

    public DifferentPasswordException() {
        super(CODE, MESSAGE, SOLUTION);
    }
}
