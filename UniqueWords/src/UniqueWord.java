import java.util.Iterator;
import java.util.*;
public class UniqueWord implements Iterable<String> {


    private Set<String> wordsSet = new HashSet<String>();

    public UniqueWord(String text){

        String[] words = text.split(" ");
        for (String w : words){
            wordsSet.add(w);
        }
    }


    @Override
    public Iterator<String> iterator() {
        return wordsSet.iterator();
    }
}
