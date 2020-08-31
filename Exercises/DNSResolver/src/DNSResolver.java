import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DNSResolver {


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter host name: ");
        String hostName = sc.next();

        InetAddress address = InetAddress.getByName(hostName);
        System.out.println("Testing reachability for  " + address.getHostAddress() + " : ");
        System.out.println(address.isReachable(1000) ? "OK" : "FAIL");

        System.out.println(address);
    }
}
