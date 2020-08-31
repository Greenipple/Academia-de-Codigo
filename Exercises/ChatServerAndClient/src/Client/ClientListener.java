package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientListener implements Runnable{

    private Socket socket;
    private BufferedReader in;

    public ClientListener(Socket socket){
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {

        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " : " + in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
