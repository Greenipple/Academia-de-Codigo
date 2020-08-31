import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        FileCopy fileCopy = new FileCopy();

        String src = "resources/original.txt";
        String dst = "resources/clone.txt";

        fileCopy.copy(src,dst);
    }
}
