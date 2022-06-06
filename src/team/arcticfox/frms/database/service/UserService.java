package team.arcticfox.frms.database.service;

import team.arcticfox.frms.database.DAO.UserDAO;
import team.arcticfox.frms.database.Domain.User;

//完成对furui_user表的操作（通过调用UserDAO完成）
public class UserService {
    //定义一个UserDAO属性
   private UserDAO userDAO= new UserDAO();

   //根据user_name,pwd返回一个User对象
    //如果查不到，就返回null
    public User CheckUser(String user_name,String pwd){
        User user = userDAO.querySingle("select * from furi_user where user_name=? and pwd =md5(?)", User.class, user_name, pwd);
        return user;
    }

}
