import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

        String urlString = "https://www.techradar.com/best/best-gaming-desk-2020-top-standing-l-shaped-and-motorized-desks";
        URL url = new URL(urlString);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String readyString;
        while((readyString = in.readLine()) != null){
            System.out.println(readyString);
        }
        in.close();


    }
}
