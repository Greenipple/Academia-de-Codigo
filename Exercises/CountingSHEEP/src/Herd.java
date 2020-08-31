public class Herd {

    public static void paintAll(String colour){
        for (int i=0; i<CountingSheep.herd.length; i++) {
            CountingSheep.herd[i] = colour;
        }
    }

    public static void paintRandom1(String colour){
        double random = Math.floor(Math.random()*CountingSheep.herd.length);
        int sheepIndex = (int) random;
        CountingSheep.herd[sheepIndex] = colour;
    }

    public static void countThem(){
        for (int i=0; i<CountingSheep.herd.length; i++){
            if (CountingSheep.herd[i]=="White") {
                System.out.println("Meeeeh!");
            }
            else if (CountingSheep.herd[i]=="Black") {
                System.out.println("OINK!");
            }
            else System.out.println("I'm lost!");
        }
    }


}
