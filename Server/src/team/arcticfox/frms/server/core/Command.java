package team.arcticfox.frms.server.core;

import team.arcticfox.frms.server.environment.Environment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class Command extends Thread {

    private static final Map<String, ICommandFunction> map = new HashMap<>() {
        {
            put("null", args -> {
                Environment.printError("Wrong command!");
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
                System.out.println("------ Help List ------");
                // helpList()
                return false;
            });
            put("info", args -> {
                System.out.println(Environment.config.server.name + " - " + Environment.config.server.uuid);
                System.out.println("\tip:\t\t" + Environment.config.server.address.ip);
                System.out.println("\tport:\t" + Environment.config.server.address.port);
                return false;
            });

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
        Scanner cin = new Scanner(System.in);
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
