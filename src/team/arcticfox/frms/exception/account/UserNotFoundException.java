package team.arcticfox.frms.exception.account;

import team.arcticfox.frms.exception.FuRuiException;

public final class UserNotFoundException extends FuRuiException {
    private static final String CODE = "AC1001";
    private static final String MESSAGE = "User not found.";
    private static final String SOLUTION = "Check whether the username is wrong, or the account is not registered, and try again.";

    public UserNotFoundException() {
        super(CODE, MESSAGE, SOLUTION);
    }
}
