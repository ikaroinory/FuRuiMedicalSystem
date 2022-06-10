package team.arcticfox.frms.exception;

import team.arcticfox.frms.system.SystemEnvironment;
import team.arcticfox.frms.exception.account.*;
import team.arcticfox.frms.exception.verification.VerificationCodeIsEmptyException;
import team.arcticfox.frms.exception.verification.VerificationCodeIsWrongException;
import team.arcticfox.frms.integration.message.IDisplayable;
import team.arcticfox.frms.integration.message.MessageBox;

import java.util.HashMap;
import java.util.Map;

public class FuRuiException extends Exception implements IDisplayable {
    private static final Map<String, FuRuiException> map = new HashMap<>() {
        {
            FuRuiException unknownException = new UnknownException();
            FuRuiException nullException = new NullException();
            FuRuiException differentPasswordException = new DifferentPasswordException();
            FuRuiException emailIsEmptyException = new EmailIsEmptyException();
            FuRuiException passwordIsEasyException = new PasswordIsEasyException();
            FuRuiException passwordIsWrongException = new PasswordIsWrongException();
            FuRuiException usernameExistsException = new UsernameExistsException();
            FuRuiException usernameIsEmptyException = new UsernameIsEmptyException();
            FuRuiException userNotFoundException = new UserNotFoundException();
            FuRuiException verificationCodeIsEmptyException = new VerificationCodeIsEmptyException();
            FuRuiException verificationCodeIsWrongException = new VerificationCodeIsWrongException();

            put(unknownException.code, unknownException);
            put(nullException.code, nullException);
            put(differentPasswordException.code, differentPasswordException);
            put(emailIsEmptyException.code, emailIsEmptyException);
            put(passwordIsEasyException.code, passwordIsEasyException);
            put(passwordIsWrongException.code, passwordIsWrongException);
            put(usernameExistsException.code, usernameExistsException);
            put(usernameIsEmptyException.code, usernameIsEmptyException);
            put(userNotFoundException.code, userNotFoundException);
            put(verificationCodeIsEmptyException.code, verificationCodeIsEmptyException);
            put(verificationCodeIsWrongException.code, verificationCodeIsWrongException);
        }
    };

    public final String code;
    public final String solution;

    protected FuRuiException(String code, String message, String solution) {
        super(message);
        this.code = code;
        this.solution = solution;
    }

    public static FuRuiException parse(String code) {
        if (map.containsKey(code)) return map.get(code);
        return map.get("FR0001");
    }

    @Override
    public void displayMessageBox() {
        String displayMessage = "Code: " + code + SystemEnvironment.EOL
                + SystemEnvironment.EOL
                + "Information: " + getMessage() + SystemEnvironment.EOL
                + SystemEnvironment.EOL
                + "Solution: " + solution + SystemEnvironment.EOL;
        MessageBox.show(MessageBox.Title.ERROR.getTitle() + " " + code, displayMessage, MessageBox.Icon.ERROR);
    }
}
