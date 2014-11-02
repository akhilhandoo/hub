package service.file;

import java.net.Socket;

/**
 * Created by akhil on 25/6/14.
 */
public class IOEndPoint implements Runnable{
    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
    }
}
