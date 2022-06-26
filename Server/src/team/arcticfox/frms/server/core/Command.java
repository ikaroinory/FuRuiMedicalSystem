package team.arcticfox.frms.server.core;

import team.arcticfox.frms.server.environment.Environment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Command extends Thread {
    private static Scanner cin;
    private static final Map<String, ICommandFunction> map = new HashMap<>() {
        {
            put("null", args -> new NullCommandFunction().fun());
            put("exit", args -> new ExitCommandFunction().fun());
            put("help", args -> new HelpCommandFunction().fun());
            put("?", args -> new HelpCommandFunction().fun());
            put("info", args -> new InfoCommandFunction().fun());
            put("time", args -> new TimeCommandFunction().fun());
            put("now", args -> new NowCommandFunction().fun());
            put("sql", args -> new SQLCommandFunction().fun(cin));
        }
    };

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
