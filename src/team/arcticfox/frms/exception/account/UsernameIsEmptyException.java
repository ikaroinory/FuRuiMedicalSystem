package team.arcticfox.frms.exception.account;

import team.arcticfox.frms.exception.FuRuiException;

public class UsernameIsEmptyException extends FuRuiException {
    private static final String CODE = "AC0001";
    private static final String MESSAGE = "Username is empty.";
    private static final String SOLUTION = "Fill in the username and try again.";

    public UsernameIsEmptyException() {
        super(CODE, MESSAGE, SOLUTION);
    }
}
