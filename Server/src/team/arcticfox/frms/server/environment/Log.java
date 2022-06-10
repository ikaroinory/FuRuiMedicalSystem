package team.arcticfox.frms.server.environment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import team.arcticfox.frms.exception.FuRuiException;
import team.arcticfox.frms.exception.NullException;
import team.arcticfox.frms.data.DateTime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

public class Log {
    private static final String dir = "logs/";

    public static void createSignInServerLog(String uuid, DateTime time, SocketAddress ip, String exceptionCode, JSONObject json) {
        String fileName = dir + "sign in/" + uuid + ".json";

        JSONObject log = new JSONObject(true) {
            {
                put("uuid", uuid);
                put("time", time.toString());
                put("ip", JSON.parseObject(JSON.toJSONString(ip, true)));
                put("exception", new JSONObject(true) {
                    {
                        put("code", exceptionCode);
                        if (exceptionCode != new NullException().code)
                            put("message", FuRuiException.parse(exceptionCode).getMessage());
                    }
                });
                put("json", json);
            }
        };

        try {
            File file = new File(fileName);
            if (!file.exists())
                file.createNewFile();

            FileOutputStream out = new FileOutputStream(fileName);
            out.write(JSON.toJSONString(log, true).getBytes(StandardCharsets.UTF_8));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createRegisterLog(String uuid, DateTime time, SocketAddress ip, String exceptionCode, JSONObject json) {
        String fileName = dir + "register/" + uuid + ".json";

        JSONObject log = new JSONObject(true) {
            {
                put("uuid", uuid);
                put("time", time.toString());
                put("ip", JSON.parseObject(JSON.toJSONString(ip, true)));
                put("exception", new JSONObject(true) {
                    {
                        put("code", exceptionCode);
                        if (exceptionCode != new NullException().code)
                            put("message", FuRuiException.parse(exceptionCode).getMessage());
                    }
                });
                put("json", json);
            }
        };

        try {
            File file = new File(fileName);
            if (!file.exists())
                file.createNewFile();

            FileOutputStream out = new FileOutputStream(fileName);
            out.write(JSON.toJSONString(log, true).getBytes(StandardCharsets.UTF_8));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
