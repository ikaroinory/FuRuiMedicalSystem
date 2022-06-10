package team.arcticfox.frms.exception;

public class NullException extends FuRuiException {
    private static final String CODE = "NULL";
    private static final String MESSAGE = "Null exception.";
    private static final String SOLUTION = "";

    public NullException() {
        super(CODE, MESSAGE, SOLUTION);
    }
}
