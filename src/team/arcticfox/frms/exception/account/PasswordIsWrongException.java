package team.arcticfox.frms.exception.account;

import team.arcticfox.frms.exception.FuRuiException;

public class PasswordIsWrongException extends FuRuiException {
    private static final String CODE = "AC1002";
    private static final String MESSAGE = "Password is wrong.";
    private static final String SOLUTION = "Check whether the password is misspelled, and try again.";

    public PasswordIsWrongException(){
        super(CODE, MESSAGE, SOLUTION);
    }
}
