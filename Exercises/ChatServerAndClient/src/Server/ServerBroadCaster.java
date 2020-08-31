package Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;

public class ServerBroadCaster {

    private LinkedList<ClientHandler> clientList;
    private Socket clientSocket;
    private String message;
    private PrintWriter out;




    public ServerBroadCaster(LinkedList clientList){
        this.clientList = clientList;
    }

    public void broadCast(String message){

        synchronized (clientList) {

            for (ClientHandler client : clientList) {

                try {
                    out = new PrintWriter(client.getClientSocket().getOutputStream(), true);
                    out.println(message);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
