package team.arcticfox.frms.account;

import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.exception.account.PasswordIsEmptyException;
import team.arcticfox.frms.exception.account.UsernameIsEmptyException;

public class Account {
    public static boolean signIn(String username, String password) throws FuRuiException {
        if (username.equals("")) throw new UsernameIsEmptyException();
        if (password.equals("")) throw new PasswordIsEmptyException();
        return true;
    }
}
