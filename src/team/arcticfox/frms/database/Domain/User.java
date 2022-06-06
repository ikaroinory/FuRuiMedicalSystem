package team.arcticfox.frms.database.Domain;

//JavaBean 和 furui_user表对应
public class User {
    private Integer id;
    private String user_name;
    private String pwd;

    public User() {//无参构造，使用阿帕奇工具类时用到反射
    }

    public User(Integer id, String user_name, String pwd) {
        this.id = id;
        this.user_name = user_name;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
