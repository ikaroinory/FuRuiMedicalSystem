import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TestMain {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 25566);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String s = "test";
        out.writeUTF("你好");
        out.close();
        socket.close();
    }
}
