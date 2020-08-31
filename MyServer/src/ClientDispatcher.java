import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClientDispatcher implements Runnable{

    Socket clientSocket;
    BufferedReader in = null;
    DataOutputStream out = null;


    String requestHeader ="";
    String pathString = "";
    String extension = "";
    String fullPath = "";
    File file = null;

    public ClientDispatcher(ServerSocket serverSocket){
        try {
            this.clientSocket = serverSocket.accept();
        } catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    public Socket getSocket(){
        return clientSocket;
    }
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());
        try{
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new DataOutputStream(clientSocket.getOutputStream());
            while((requestHeader = in.readLine()) == null) {
                requestHeader = in.readLine();
            }

            System.out.println(requestHeader+" on "+Thread.currentThread().getName());



            String[] request = requestHeader.split(" ");
            pathString = request[1];
            extension = pathString.substring(pathString.lastIndexOf(".")+1);
            fullPath = "d:/academia/projetos/MyServer" + pathString;

            file = new File(fullPath);




            if(!requestHeader.startsWith("GET")){
                System.out.println("Unacceptable request from ungrateful Client. Exiting....");
                System.exit(1);
            }

            if (!file.exists()){
                System.out.println("File not found!!");
                // in.close();
                //  out.close();
                // continue;
            }



            if(extension.equals("txt")){
                returnText();
            }

            else{
                returnImage();
            }



        } catch (IOException ioe) {
            System.out.println("Receiving error: " + ioe.getMessage());
        }finally {
            try {
                if(in != null)  {
                    in.close();
                }
                if(out != null) {
                    out.close();
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }

    private void returnImage() {
        try{
            out.writeBytes(
                    "HTTP/1.1 200 OK\r\n"+
                            "Content-type: image/jpg\r\n"+
                            "Content-Length: "+ file.length() +"\r\n"+
                            "\r\n");
            byte[] array = Files.readAllBytes(Paths.get(fullPath));
            out.write(array);
        } catch (IOException ioe){
            System.out.println("Sending error...." +ioe.getMessage());
        }
    }

    private void returnText() {
        try {
            out.writeBytes(
                    "HTTP/1.1 200 OK\r\n" +
                            "Content-type: text/html; charset=UTF-8\r\n" +
                            "Content-Length: " + file.length() + "\r\n" +
                            "\r\n");

            byte[] array = Files.readAllBytes(Paths.get(fullPath));
            out.write(array);
        } catch (IOException ioe){
            System.out.println("Sending error...." +ioe.getMessage());
        }

    }

}

