import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        while(true) {

            String hostName = "localhost";
            int portNumber = 9001;

            byte[] sendBuffer = new byte[1024];
            byte[] receiveBuffer = new byte[1024];

            DatagramSocket socket = new DatagramSocket(portNumber);
            int destPort = 9000;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter message: ");
            String message = scanner.next();

            sendBuffer = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(hostName), destPort);
            socket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);
            String returnedMessage = new String(receivePacket.getData());
            System.out.println(returnedMessage);

            socket.close();
        }

    }
}
