public class Sheep {
    public static void main(String[] args) {
        String[] herd = new String[100];

        double random = Math.floor(Math.random()*100);
        int blackSheepIndex = (int) random;
        herd[blackSheepIndex] = "Black";


        for (int i =0; i<100; i++) {
           if (herd[i] == null) {
               herd[i] ="White";
           }
         }

        for (int i=0; i<100; i++) {
            System.out.println(i+1);
            if (herd[i] == "White") {
                System.out.println("Meeeeeeeh!");
            }
            else if (herd[i] == "Black") System.out.println("OINK!");
            }

        for (int i=0; i<100; i++) {
            herd[i] = "Pink";
        }

    }
}
