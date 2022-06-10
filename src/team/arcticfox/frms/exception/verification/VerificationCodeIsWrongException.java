package team.arcticfox.frms.exception.verification;

import team.arcticfox.frms.exception.FuRuiException;

public class VerificationCodeIsWrongException extends FuRuiException {
    private static final String CODE = "VE0002";
    private static final String MESSAGE = "Verification code is wrong.";
    private static final String SOLUTION = "Please fill in the new verification code.";

    public VerificationCodeIsWrongException() {
        super(CODE, MESSAGE, SOLUTION);
    }
}
