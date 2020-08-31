import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {



    public void copy(String src,String dst) throws IOException {

        FileInputStream inputStream = new FileInputStream(src);
        FileOutputStream outputStream = new FileOutputStream(dst);

        byte[] buffer = new byte[1024];

        int bytesRead=inputStream.read(buffer);

        while(bytesRead != -1){
            outputStream.write(buffer,0,bytesRead);
            bytesRead = inputStream.read(buffer);
        }
        inputStream.close();
        outputStream.close();

            }
}
