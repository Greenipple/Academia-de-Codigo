package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public final static int serverPort = 9000;

    private ClientHandler clientHandler = null;
    private LinkedList<ClientHandler> clientList = null;
    private ServerSocket serverSocket = null;
    private Socket clientSocket = null;
    private ExecutorService cachedPool = null;
    // private BufferedWriter out = null;
    private ServerBroadCaster broadCaster;


    public static void main(String[] args) {

        Server server = new Server();
        server.serverLauncher(serverPort);

        while (true) {
            server.runServer();
        }

    }
    private void runServer(){

        System.out.println("Waiting for client connection....");
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        clientHandler = new ClientHandler(clientSocket,broadCaster);
        System.out.println("Client connected ");
        synchronized (clientList) {
            clientList.add(clientHandler);
        }
        cachedPool.submit(clientHandler);
        //System.out.println(Thread.currentThread().getName() + " says " + clientHandler.getInputString());
    }

    private void serverLauncher(int port){

        try {
            serverSocket = new ServerSocket(port);
            cachedPool = Executors.newCachedThreadPool();
            clientList = new LinkedList<ClientHandler>();
            broadCaster = new ServerBroadCaster(clientList);
            //out = new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ServerBroadCaster getBroadCaster(){
        return broadCaster;
    }

}
