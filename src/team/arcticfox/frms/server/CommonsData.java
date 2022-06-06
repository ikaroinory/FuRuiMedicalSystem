package team.arcticfox.frms.server;

import team.arcticfox.frms.database.Domain.Medicine;
import team.arcticfox.frms.database.Domain.User;

public class CommonsData {
    private String op;
    private String result;
    private User user;
    private Medicine medicine;

    public CommonsData() {
        op = null;
        result = null;
        user = null;
        medicine=null;
    }

    public String getop() {
        return op;
    }

    public User getuser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
