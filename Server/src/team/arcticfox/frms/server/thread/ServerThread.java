package team.arcticfox.frms.server.thread;

import team.arcticfox.frms.server.environment.Environment;
import team.arcticfox.frms.system.Function;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class ServerThread extends Thread implements ITerminable {
    private final String serverName;
    private int port;
    protected boolean terminated;
    protected ServerSocket server;
    protected Socket socket;

    public ServerThread(String serverName, int port) {
        super();
        this.serverName = serverName;
        this.port = port;
        this.terminated = false;
        try {
            this.server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract void monitor();

    protected void end() {
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Environment.printInfo(serverName + " running.");
        monitor();
        end();
        Environment.printInfo(serverName + " closed.");
    }
    @Override
    public void terminate() {
        while (socket != null) ;

        terminated = true;
        try {
            Socket temp = new Socket("localhost", port);
            temp.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        end();
    }
}
