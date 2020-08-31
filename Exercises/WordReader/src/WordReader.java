import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class WordReader implements Iterable<String>{

    FileReader reader;
    BufferedReader bReader;
    String line = "";
    String result = "";
    String[] words;

    public WordReader(String src) throws IOException {


        this.reader = new FileReader(src);

        this.bReader = new BufferedReader(reader);


        while((line = bReader.readLine()) != null) {
            result += line + "\n";
        }

        bReader.close();

        words = result.split("\\W+");

    }

    @Override
    public Iterator iterator() {
        return new WordIterator();
        }

    private class WordIterator implements Iterator<String>{

        private int index=0;

        @Override
        public boolean hasNext(){
            return index < words.length;
        }

        @Override
        public String next() {
            index++;
            return words[index-1];
        }
    }
}
