package team.arcticfox.frms.exception.account;

import team.arcticfox.frms.exception.FuRuiException;

public final class UsernameExistsException extends FuRuiException {
    private static final String CODE = "AC2001";
    private static final String MESSAGE = "Username has been existed.";
    private static final String SOLUTION = "Please try another username.";

    public UsernameExistsException(){
        super(CODE, MESSAGE, SOLUTION);
    }
}
