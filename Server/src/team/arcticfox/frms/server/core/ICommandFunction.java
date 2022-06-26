package team.arcticfox.frms.server.core;

import team.arcticfox.frms.data.DateTime;
import team.arcticfox.frms.database.Database;
import team.arcticfox.frms.server.environment.Environment;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public interface ICommandFunction {
    boolean fun(Object... args);
}

final class NullCommandFunction implements ICommandFunction {
    @Override
    public boolean fun(Object... args) {
        Environment.printError("Wrong command! Please enter \"help\" or \"?\" to view the help list.");
        return false;
    }
}

final class ExitCommandFunction implements ICommandFunction {
    @Override
    public boolean fun(Object... args) {
        Environment.signInServer.terminate();
        Environment.registerServer.terminate();
        Environment.cartServer.terminate();
        Environment.orderServer.terminate();
        Environment.userToServerChatServer.terminate();
        Environment.serverToServiceChatServer.terminate();
        Environment.serviceToServerChatServer.terminate();
        Environment.serverToUserChatServer.terminate();
        return true;
    }
}

final class HelpCommandFunction implements ICommandFunction {
    @Override
    public boolean fun(Object... args) {
        System.out.println("------------ Help List ------------");
        System.out.println("?   \t-\tView help list.");
        System.out.println("help\t-\tView help list.");
        System.out.println("exit\t-\tExit the server.");
        System.out.println("info\t-\tView server information.");
        System.out.println("time\t-\tGet current system time.");
        System.out.println("sql \t-\tExecute SQL statement.");
        System.out.println("-----------------------------------");
        return false;
    }
}

final class InfoCommandFunction implements ICommandFunction {
    @Override
    public boolean fun(Object... args) {
        System.out.println(Environment.config.server.name + " - " + Environment.config.server.uuid);
        System.out.println("\tip:\t\t" + Environment.config.server.address.ip);
        System.out.println("\tport:\t" + Environment.config.server.address.port);
        return false;
    }
}

final class TimeCommandFunction implements ICommandFunction {
    @Override
    public boolean fun(Object... args) {
        System.out.println("Current time: " + DateTime.now());
        return false;
    }
}

final class NowCommandFunction implements ICommandFunction {
    @Override
    public boolean fun(Object... args) {
        System.out.println("Current time: " + DateTime.now());
        return false;
    }
}

final class SQLCommandFunction implements ICommandFunction {
    @Override
    public boolean fun(Object... args) {
        Database db = new Database(Environment.config.database.name);
        db.open(Environment.config.database.root.username, Environment.config.database.root.password);
        boolean result;
        String sql;
        while (true) {
            Environment.printInfo("Please enter a line of sql statement:");
            sql = ((Scanner) args[0]).nextLine();

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
                    splitLine.append("-".repeat(48));
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
        }
        else
            Environment.printInfo("Successful execution.");
        db.close();
        return false;
    }
}
