import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static final String FILE_PATH = "D:\\academia\\projetos\\Fileanalizer\\src\\main\\resources\\test.txt";

    public static void main(String[] args) throws IOException {
        FileAnalizer  fileAnalizer = new FileAnalizer();

        System.out.println(Arrays.toString(fileAnalizer.getWords(FILE_PATH)));
        System.out.println(fileAnalizer.countWords(FILE_PATH));
        System.out.println(fileAnalizer.getFirstWordLongerThan(FILE_PATH,10));
    }
}
