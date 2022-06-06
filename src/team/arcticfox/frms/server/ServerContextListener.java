package team.arcticfox.frms.server;

import team.arcticfox.frms.database.Domain.User;
import team.arcticfox.frms.database.service.UserService;
import team.arcticfox.frms.exception.FuRuiException;

import javax.sql.CommonDataSource;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerContextListener extends Thread {
    @Override
    public void run() {
        Socket socket = null;

        try {
            while (true) {
                ServerSocket server = new ServerSocket(10086);
                socket = server.accept();

                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

                CommonsData commonsData = (CommonsData) input.readObject();
                socket.shutdownInput();

                if ("login".equals(commonsData.getop())) {
                    String username = commonsData.getuser().getUser_name();
                    String password = commonsData.getuser().getPwd();

                    UserService userService = new UserService();

                    User user = userService.CheckUser(username, password);

                    commonsData.setUser(user);
                    commonsData.setResult("登陆成功！");
                    log("用户" + username + "登录");
                } else if ("register".equals(commonsData.getop())) {
                    String username = commonsData.getuser().getUser_name();
                    String password = commonsData.getuser().getPwd();

                    UserService userService = new UserService();

                    User user = userService.CheckUser(username, password);

                    if (user == null) {
                        //---------调用向数据库添加用户的方法，完成注册

                        log("向数据库中添加新用户" + username);
                        commonsData.setResult("注册成功！");
                    } else {
                        log("注册" + username + "失败，数据库中已存在相同用户名");
                        commonsData.setResult("该用户名已经被注册,请输入新的用户名! ");
                    }
                }

                output.writeObject(commonsData);
                output.flush();
                socket.shutdownOutput();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 打印日志
    public void log(Object msg) {
        Date date = new Date();
        System.out.println("服务器: " + date + "  " + msg);
    }

    public static void main(String[] args) {
        new ServerContextListener().start();
    }
}
