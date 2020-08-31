import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {


    int serverPort = 9000;
    ServerSocket serverSocket = null;
    Socket socket = null;
    ExecutorService fixedPool = Executors.newFixedThreadPool(10);

    public Server() {

        try {

            serverSocket = new ServerSocket(serverPort);
            

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void main(String[] args) {

        Server server = null;

        server = new Server();
        while (true) {

            server.handleClient();
        }

    }

    public void handleClient() {

        try {



            System.out.println("Waiting for my favourite Client....");
            ClientDispatcher clientDispatcher = new ClientDispatcher(serverSocket);
            socket = clientDispatcher.getSocket();
            System.out.println("Client connected.");

            fixedPool.submit(clientDispatcher);
            //Thread clientThread = new Thread(clientDispatcher);
            //clientThread.start();
            //fixedPool.shutdown();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}