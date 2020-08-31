public class PlayGround {

   static String[] players = new String[] {"Adriana","Patricio","Tiago","Rafa","Joel","Chico","Diney","Eduardo","Andreia","Joana"};
   static int[] playBetween =new int[] {97,30};
   static int max = Math.max(playBetween[0],playBetween[1]);
   static int min = Math.min(playBetween[0],playBetween[1]);
   static int range = Math.abs(playBetween[0]-playBetween[1])+1;

    public static void main(String[] args) {

         GuessANumber.start();

    }
}
