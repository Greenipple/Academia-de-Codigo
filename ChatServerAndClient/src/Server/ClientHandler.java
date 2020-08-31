package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler implements Runnable{


    private Socket clientSocket;
    private BufferedReader in;
    private String inputString;
    private String outputString;
    private ServerBroadCaster broadCaster;
    private String clientName = "";

    public ClientHandler(Socket clientSocket, ServerBroadCaster broadCaster){

        System.out.println("Instanciating " + clientSocket);

        this.broadCaster = broadCaster;

        this.clientSocket = clientSocket;

        try {
            in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            System.out.println(Thread.currentThread().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void run() {
        while(true) {
            try {
                System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                inputString =  in.readLine();

                outputString = this.hasName()? clientName + " says: " + inputString : inputString;

                checkCommands();

                System.out.println(Thread.currentThread().getName() + " : " + outputString);

                broadCaster.broadCast(outputString);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public boolean hasName(){
        return clientName.length() > 0;
    }
    public String getInputString(){
        return inputString;
    }

    public Socket getClientSocket(){
        return this.clientSocket;
    }
    public void checkCommands(){
        String[] string = inputString.split(" ");
        if (string[0].equals("/setName")){
            this.clientName = string[1];
            outputString = "";
        }
    }
}
