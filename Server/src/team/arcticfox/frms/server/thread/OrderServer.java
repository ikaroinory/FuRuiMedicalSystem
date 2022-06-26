package team.arcticfox.frms.server.thread;

import team.arcticfox.frms.data.Order;
import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.server.environment.Environment;
import team.arcticfox.frms.system.Function;
import team.arcticfox.frms.system.SystemEnvironment;
import team.arcticfox.frms.utp.OrderProtocolClientToServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;

final class OrderSystem {
    static void create(Order order) {
        String fileName = Environment.DIR_ORDER + order.uuid + ".json";
        Function.createFile(fileName);

        try {
            FileOutputStream out = new FileOutputStream(fileName);
            out.write(order.toJsonString().getBytes(StandardCharsets.UTF_8));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Database db = new Database(SystemEnvironment.DB_NAME);
        db.open();
        for (var item : order.list) {
            try {
                ResultSet rs = db.sqlQuery(Function.getSQL_Query_MedicineList_ById(item.id));
                rs.first();
                int amount = rs.getInt(SystemEnvironment.COLUMN_AMOUNT);
                db.sqlUpdate(Function.getSQL_Update_MedicineList_Amount_byId(item.id, amount - item.amount));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        db.close();
    }
}

public final class OrderServer extends ServerThread {
    public OrderServer() {
        super("Order Server",Environment.config.server.list.order.port);
    }

    @Override
    protected void monitor() {
        while (!terminated) {
            try {
                socket = null;
                socket = server.accept();

                if (terminated) break;

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                OrderProtocolClientToServer receivedUtp = OrderProtocolClientToServer.parse(in.readUTF());

                Environment.printSession("Order session: " + socket.getRemoteSocketAddress());
                Environment.printSession("Username: " + receivedUtp.username + "(id: " + receivedUtp.id + ")");

                Order order = Order.parse(receivedUtp);
                OrderSystem.create(order);

                out.writeUTF(order.uuid);
                out.flush();

                Environment.printSession("Created order: " + order.uuid);

                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
