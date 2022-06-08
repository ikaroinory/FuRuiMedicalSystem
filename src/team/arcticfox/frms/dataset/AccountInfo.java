package team.arcticfox.frms.dataset;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.account.Account;
import team.arcticfox.frms.program.environment.Constant;
import team.arcticfox.frms.security.Base64;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountInfo {
    @JSONField(name = "id")
    public int id;                       // Id.                  Type: Integer           Encode Type: None
    @JSONField(name = "username", ordinal = 1)
    public String username;              // Username.            Type: String            Encode Type: Base64
    @JSONField(name = "email", ordinal = 2)
    public String email;                 // Email.               Type: String            Encode Type: Base64
    @JSONField(name = "password", ordinal = 3)
    public String password;              // Password.            Type: String            Encode Type: Base64 -> MD5
    @JSONField(name = "permission", ordinal = 4, serializeUsing = AccountPermissionCoder.class, deserializeUsing = AccountPermissionCoder.class)
    public AccountPermission permission; // Account Permission   Type: AccountPermission Encode Type: None
    @JSONField(name = "registration-time", ordinal = 5, serializeUsing = DateTimeCoder.class, deserializeUsing = DateTimeCoder.class)
    public DateTime registrationTime;    // Registration Time.   Type: DateTime          Encode Type: None
    @JSONField(name = "destruction-time", ordinal = 6, serializeUsing = DateTimeCoder.class, deserializeUsing = DateTimeCoder.class)
    public DateTime destructionTime;     // Destruction Time.    Type: DateTime          Encode Type: None
    @JSONField(name = "last-login-time", ordinal = 7, serializeUsing = DateTimeCoder.class, deserializeUsing = DateTimeCoder.class)
    public DateTime lastLoginTime;       // Last Login Time.     Type: DateTime          Encode Type: None


    public AccountInfo() {
        this(0, "", "", "", AccountPermission.NULL, DateTime.now(), DateTime.now(), DateTime.now());
    }

    public AccountInfo(int id, String username, String email, String password, AccountPermission permission,
                       DateTime registrationTime, DateTime destructionTime, DateTime lastLoginTime
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.permission = permission;
        this.registrationTime = registrationTime;
        this.destructionTime = destructionTime;
        this.lastLoginTime = lastLoginTime;
    }

    public static AccountInfo Parse(ResultSet rs) {
        int id = 0;
        String username = "";
        String email = "";
        String password = "";
        AccountPermission permission = AccountPermission.NULL;
        DateTime registrationTime = null;
        DateTime destructionTime = null;
        DateTime lastLoginTime = null;
        try {
            id = rs.getInt(Constant.COLUMNLABEL_ID);
            username = Base64.decode(rs.getString(Constant.COLUMNLABEL_USERNAME));
            email = Base64.decode(rs.getString(Constant.COLUMNLABEL_EMAIL));
            password = Base64.decode(rs.getString(Constant.COLUMNLABEL_PASSWORD));
            permission = AccountPermission.parse(rs.getString(Constant.COLUMNLABEL_PERMISSION));
            registrationTime = DateTime.parse(rs.getString(Constant.COLUMNLABEL_REGISTRATIONTIME));
            destructionTime = DateTime.parse(rs.getString(Constant.COLUMNLABEL_DESTRUCTIONTIME));
            lastLoginTime = DateTime.parse(rs.getString(Constant.COLUMNLABEL_LASTLOGINTIME));

        } catch (SQLException e) {
            // Do nothing.
        }
        return new AccountInfo(id, username, email, password, permission, registrationTime, destructionTime, lastLoginTime);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
