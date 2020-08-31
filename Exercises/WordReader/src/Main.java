import java.io.IOException;

public class Main {

    private static String FILE_PATH = "resources/lorem_ipsum.txt";
    public static void main(String[] args) throws IOException {

        WordReader wordReader = new WordReader(FILE_PATH);
        for (String word: wordReader){
            System.out.println(word);
        }
    }
}
