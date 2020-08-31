package Client;

import Server.Server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private PrintWriter out;
    private ClientListener listener;
    private final String host = "localhost";
    private final int port = Server.serverPort;

    Thread listeningThread;



    public Client(){


        try {
            socket = new Socket(host, port);
            out = new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        listener = new ClientListener(this.socket);
        listeningThread = new Thread(listener);
        listeningThread.start();
    }

    public static void main(String[] args) {

        Client client =new Client();

        Scanner scanner = new Scanner(System.in);

        while (true) {


            System.out.println("Enter message : ");
            String message = scanner.nextLine();

            try {
                client.write(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    public void write(String message) throws IOException {
        out.println(message);
    }

    public void close(BufferedWriter bw) throws IOException {
        bw.close();
    }

}
