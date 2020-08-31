import java.util.HashMap;
import java.util.Iterator;

public class WordHistogram extends HashMap implements Iterable<String> {

    public  void insert(String text){

        String[] words = text.split(" ");

        for (String w : words){
            int ocur=1;

            if(this.containsKey(w)){
                this.put(w,(int)this.get(w)+1);
            }
            else this.put(w,ocur);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return this.keySet().iterator();
    }
}

