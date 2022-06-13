package team.arcticfox.frms.server.core;

import team.arcticfox.frms.data.DateTime;
import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.server.environment.Environment;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Command extends Thread {
    private static Scanner cin;
    private static final Map<String, ICommandFunction> map = new HashMap<>() {
        {
            put("null", args -> {
                Environment.printError("Wrong command! Please enter \"help\" or \"?\" to view the help list.");
                return false;
            });
            put("exit", args -> {
                Environment.signInServer.terminate();
                Environment.registerServer.terminate();
                Environment.cartServer.terminate();
                Environment.orderServer.terminate();
                return true;
            });
            put("help", args -> {
                helpList();
                return false;
            });
            put("?", args -> {
                helpList();
                return false;
            });
            put("info", args -> {
                System.out.println(Environment.config.server.name + " - " + Environment.config.server.uuid);
                System.out.println("\tip:\t\t" + Environment.config.server.address.ip);
                System.out.println("\tport:\t" + Environment.config.server.address.port);
                return false;
            });
            put("time", args -> {
                System.out.println("Current time: " + DateTime.now());
                return false;
            });
            put("now", args -> {
                System.out.println("Current time: " + DateTime.now());
                return false;
            });
            put("sql", args -> {
                Database db = new Database(Environment.config.database.name);
                db.open(Environment.config.database.root.username, Environment.config.database.root.password);
                boolean result;
                String sql;
                while (true) {
                    Environment.printInfo("Please enter a line of sql statement:");
                    sql = cin.nextLine();

                    try {
                        result = db.sql(sql);
                    } catch (SQLException e) {
                        Environment.printError("Please enter the correct SQL statement.");
                        continue;
                    }
                    break;
                }

                if (result) {
                    Environment.printInfo("Result: ");
                    ResultSet resultSet = db.sqlQuery(sql);
                    try {
                        ResultSetMetaData metaData = resultSet.getMetaData();

                        int columnCount = metaData.getColumnCount();
                        StringBuilder temp = new StringBuilder();
                        StringBuilder splitLine = new StringBuilder();
                        for (int i = 0; i < columnCount; i++) {
                            temp.append(String.format("%-48s", metaData.getColumnName(i + 1)));
                            for (int j = 0; j < 48; j++) splitLine.append("-");
                        }
                        System.out.println(temp);
                        System.out.println(splitLine);
                        while (resultSet.next()) {
                            temp = new StringBuilder();
                            for (int i = 0; i < columnCount; i++)
                                temp.append(String.format("%-48s", resultSet.getString(i + 1)));
                            System.out.println(temp);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else
                    Environment.printInfo("Successful execution.");
                db.close();
                return false;
            });
        }
    };

    private static void helpList() {
        System.out.println("------------ Help List ------------");
        System.out.println("?   \t-\tView help list.");
        System.out.println("help\t-\tView help list.");
        System.out.println("exit\t-\tExit the server.");
        System.out.println("info\t-\tView server information.");
        System.out.println("time\t-\tGet current system time.");
        System.out.println("-----------------------------------");
    }

    private boolean sendCommand(String line) {
        String[] list = line.split(" ");
        String cmd = list[0];

        if (map.containsKey(cmd))
            return map.get(cmd).fun(list);
        else
            return map.get("null").fun(list);
    }

    private void main() {
        cin = new Scanner(System.in);
        do {
            String cmd = cin.nextLine();
            if (sendCommand(cmd))
                break;
        } while (true);
        Environment.printInfo("Command line closed.");
    }

    @Override
    public void run() {
        main();
    }

    @Override

    public synchronized void start() {
        Environment.printInfo("Command line started.");
        super.start();
    }
}
