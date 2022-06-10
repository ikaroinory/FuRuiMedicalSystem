package team.arcticfox.frms.exception;

public class UnknownException extends FuRuiException{
    private static final String CODE = "FR0001";
    private static final String MESSAGE = "Unknown exception.";
    private static final String SOLUTION = "Please contact the author for solution.";

    public UnknownException() {
        super(CODE, MESSAGE, SOLUTION);
    }
}
