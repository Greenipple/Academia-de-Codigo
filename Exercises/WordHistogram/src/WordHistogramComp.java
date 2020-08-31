import java.util.*;

public class WordHistogramComp implements Iterable<String>{


    private HashMap<String,Integer> wordsMap = new HashMap<>();
    //private Set<String> wordsSet = new HashSet<>();

    public  void insert(String text){

        String[] words = text.split(" ");

        for (String w : words){
            int ocur=1;

           if(wordsMap.containsKey(w)){
               wordsMap.put(w,wordsMap.get(w)+1);
           }
            else wordsMap.put(w,ocur);
        }
    }

    public int size(){
        return wordsMap.size();
    }

    public int get(String word){
        return wordsMap.get(word);
    }
    //Iterator iterator = wordsMap.entrySet().

    @Override
    public Iterator<String> iterator() {
        return wordsMap.keySet().iterator();
    }
}
