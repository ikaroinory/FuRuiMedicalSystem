import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.dataset.*;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class Test {
    @JSONField(name = "date-time", serializeUsing = AccountPermissionCoder.class, deserializeUsing = AccountPermissionCoder.class)
    public AccountPermission dateTime;

    @Override
    public String toString() {
        return dateTime.toString();
    }
}

public class TestMain {
    public static void main(String[] args) throws Exception {

        String s = "{\n" +
                "    \"id\": 1,\n" +
                "    \"username\": \"root\",\n" +
                "    \"email\": \"root@arcticfox.com\",\n" +
                "    \"permission\": \"Owner\",\n" +
                "    \"registration-time\": \"2022-05-26 14:07:51\",\n" +
                "    \"destruction-time\": \"1900-01-01 00:00:00\",\n" +
                "    \"last-login-time\": \"2022-06-08 21:27:45\"\n" +
                "}";

        AccountInfo accountInfo = JSON.parseObject(s, AccountInfo.class);
        System.out.println(accountInfo);


        /*
        Socket socket = new Socket("localhost", 25566);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String s = "test";
        out.writeUTF("你好");
        out.close();
        socket.close();
*/
    }
}
