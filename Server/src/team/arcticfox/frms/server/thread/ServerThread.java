package team.arcticfox.frms.server.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class ServerThread extends Thread implements ITerminable {
    private int port;
    protected boolean terminated;
    protected ServerSocket server;
    protected Socket socket;

    public ServerThread(int port) {
        super();
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
        monitor();
        end();
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
