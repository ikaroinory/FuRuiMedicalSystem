package team.arcticfox.frms.dataset;

import team.arcticfox.frms.security.Base64;

import java.sql.Time;

enum AccountPermission {
    OWNER(0),
    ADMIN(2),
    USER(5);

    int id;

    AccountPermission(int id) {
        this.id = id;
    }
}

public class AccountInfo {
    private String id;                      // Id.                  Type: Integer           Encode Type: None
    private String username;                // Username.            Type: String            Encode Type: Base64
    private String email;                   // Email.               Type: String            Encode Type: Base64
    private String password;                // Password.            Type: String            Encode Type: Base64 -> MD5
    private Time registrationTime;          // Registration Time.   Type: Time              Encode Type: None
    private String status;                  // Account Statue.      Type: AccountStatus     Encode Type: None
    private AccountPermission permission;   // Account Permission   Type: AccountPermission Encode: None

    public AccountInfo(String id, String username, String email, String password, Time registrationTime, AccountPermission permission) {
        this.id = Base64.encode(id);
        this.username = Base64.encode(username);
        this.email = Base64.encode(email);
        this.password = Base64.encode(password);
        this.registrationTime = registrationTime;
        this.permission=permission;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return Base64.decode(username);
    }

    public String getEmail() {
        return Base64.decode(email);
    }

    public String getPassword() {
        return password;
    }

    public Time getRegistrationTime() {
        return registrationTime;
    }

    public String getStatus() {
        return status;
    }

    public AccountPermission getPermission() {
        return permission;
    }
}
