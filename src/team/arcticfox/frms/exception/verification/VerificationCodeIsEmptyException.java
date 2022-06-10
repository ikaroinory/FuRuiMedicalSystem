package team.arcticfox.frms.exception.verification;

import team.arcticfox.frms.exception.FuRuiException;

public class VerificationCodeIsEmptyException extends FuRuiException {
    private static final String CODE = "VE0001";
    private static final String MESSAGE = "Verification code is empty.";
    private static final String SOLUTION = "Fill in the verification code and try again.";

    public VerificationCodeIsEmptyException() {
        super(CODE, MESSAGE, SOLUTION);
    }
}
