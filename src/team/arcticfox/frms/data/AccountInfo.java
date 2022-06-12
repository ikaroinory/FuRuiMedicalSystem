package team.arcticfox.frms.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.security.Base64;
import team.arcticfox.frms.system.Function;
import team.arcticfox.frms.system.SystemEnvironment;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class AccountInfo implements IJsonTextable {
    @JSONField(name = "id")
    public int id;
    @JSONField(name = "username", ordinal = 1)
    public String username;
    @JSONField(name = "email", ordinal = 2)
    public String email;
    @JSONField(name = "password", serialize = false)
    public String password;
    @JSONField(name = "permission", ordinal = 3, serializeUsing = AccountPermissionSerializer.class, deserializeUsing = AccountPermissionSerializer.class)
    public AccountPermission permission;
    @JSONField(name = "registration-time", ordinal = 4, serializeUsing = DateTimeSerializer.class, deserializeUsing = DateTimeSerializer.class)
    public DateTime registrationTime;
    @JSONField(name = "destruction-time", ordinal = 5, serializeUsing = DateTimeSerializer.class, deserializeUsing = DateTimeSerializer.class)
    public DateTime destructionTime;
    @JSONField(name = "last-login-time", ordinal = 6, serializeUsing = DateTimeSerializer.class, deserializeUsing = DateTimeSerializer.class)
    public DateTime lastLoginTime;


    public AccountInfo() {
        this(0, null, null, null, null, null, null, null);
    }

    public AccountInfo(int id, String username, String email, String password, AccountPermission permission, DateTime registrationTime, DateTime destructionTime, DateTime lastLoginTime) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.permission = permission;
        this.registrationTime = registrationTime;
        this.destructionTime = destructionTime;
        this.lastLoginTime = lastLoginTime;
    }


    private static AccountInfo parse(ResultSet rs) {
        int id = 0;
        String username = null;
        String email = null;
        String password = null;
        AccountPermission permission = null;
        DateTime registrationTime = null;
        DateTime destructionTime = null;
        DateTime lastLoginTime = null;
        try {
            id = rs.getInt(SystemEnvironment.COLUMN_ID);
            username = Base64.decode(rs.getString(SystemEnvironment.COLUMN_USERNAME));
            email = Base64.decode(rs.getString(SystemEnvironment.COLUMN_EMAIL));
            password = Base64.decode(rs.getString(SystemEnvironment.COLUMN_PASSWORD));
            permission = AccountPermission.parse(rs.getString(SystemEnvironment.COLUMN_PERMISSION));
            registrationTime = DateTime.parse(rs.getString(SystemEnvironment.COLUMN_REGISTRATION_TIME));
            destructionTime = DateTime.parse(rs.getString(SystemEnvironment.COLUMN_DESTRUCTION_TIME));
            lastLoginTime = DateTime.parse(rs.getString(SystemEnvironment.COLUMN_LAST_LOGIN_TIME));

        } catch (SQLException e) {
            // Do nothing.
        }
        return new AccountInfo(id, username, email, password, permission, registrationTime, destructionTime, lastLoginTime);
    }

    public static AccountInfo parse(String s) {
        return JSON.parseObject(s, AccountInfo.class);
    }

    public static AccountInfo getAccountInfo(String username) {
        Database db = new Database(SystemEnvironment.DB_NAME);
        db.open();
        ResultSet rs = db.sqlQuery(Function.getSQL_Query_AccountInfo_ByName(username));
        AccountInfo accountInfo = null;
        try {
            if (rs.first())
                accountInfo = AccountInfo.parse(rs);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return accountInfo;
    }


    @Override
    public JSONObject toJsonObject() {
        return JSON.parseObject(toJsonString());
    }

    @Override
    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}
