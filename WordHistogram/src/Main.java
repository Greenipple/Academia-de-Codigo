public class Main {

    private static final String TEXT = "what is this madness is this madness what is life batata batata batata batatuxa";

    public static void main(String[] args) {
        //WordHistogramComp wordHistogram = new WordHistogramComp();
        WordHistogram wordHistogram = new WordHistogram();
        wordHistogram.insert(TEXT);

        System.out.println("The map has " + wordHistogram.size() + " distinct words. \n");

        for (String word : wordHistogram) {
            System.out.println(word + ": " + wordHistogram.get(word));
        }
    }
}
