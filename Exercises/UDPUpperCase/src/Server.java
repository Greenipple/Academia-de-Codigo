import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {

        while(true) {
            int portNumber = 9000;

            byte[] sendBuffer = new byte[1024];
            byte[] receiveBuffer = new byte[1024];

            DatagramSocket socket = new DatagramSocket(portNumber);

            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);

            String string = new String(receivePacket.getData());
            String upperCase = string.toUpperCase();
            System.out.println(upperCase);
            sendBuffer = upperCase.getBytes();


            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
            socket.send(sendPacket);

            socket.close();
        }

    }
}
