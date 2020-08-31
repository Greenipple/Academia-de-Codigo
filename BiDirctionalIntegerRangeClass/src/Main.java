public class Main {
    public static void main(String[] args) {


        Range range =new Range(10);
        range.setGrowing(false);

        for(Integer integer : range){
            System.out.println(integer);
        }
    }
}
