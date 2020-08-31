public class GuessANumber {
    //Set target
    private static int target = RandomBetween.please(PlayGround.playBetween[0], PlayGround.playBetween[1]);

    private static boolean targetIsFound;

    public static void start() {
        System.out.println("Target is " + target);

        // Ask each player
        while (!targetIsFound) {
            for (int i = 0; i < PlayGround.players.length; i++) {
                int playerGuess = Player.guess();
                System.out.println(PlayGround.players[i] + "'s guess is " + playerGuess);

                //Check if it's the right number

                if (playerGuess == target) {
                    System.out.println("And it's CORRECT!!! " + PlayGround.players[i] + " WINS!!!!");
                    targetIsFound = true;
                    break;
                } else {
                    System.out.println("...And it's wrong.");
                }

            }
        }
    }
}
