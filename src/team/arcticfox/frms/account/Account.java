package team.arcticfox.frms.account;

public class Account{
    public static boolean signIn(String username,String password){
        if(username.equals("")) return false;
        if(password.equals("")) return false;
        return true;
    }
}
