import java.util.Arrays;

public class Main {

    private static final String TEXT = "sara mari robin não sei que escrever qualquer coisa mari coisa não mari";

    public static void main(String[] args) {

        UniqueWord wc = new UniqueWord(TEXT);

        for (String word : wc) {
            System.out.println(word);
        }
        //System.out.println(Arrays.toString(wc.word));
    }
}
