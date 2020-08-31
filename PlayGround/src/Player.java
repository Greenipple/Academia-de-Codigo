import java.util.Arrays;

public class Player {

    public static boolean[] usedNumbers = new boolean[PlayGround.range];

    public static int guess() {
        int numberPlayerIsThinkingOf = 0;
        boolean possible = false;
        while (!possible) {
            numberPlayerIsThinkingOf = RandomBetween.please(PlayGround.min, PlayGround.max);
            if (!usedNumbers[numberPlayerIsThinkingOf - PlayGround.min]) {
                possible = true;
            }
        }
        usedNumbers[numberPlayerIsThinkingOf-PlayGround.min] = true;
        return numberPlayerIsThinkingOf;
    }
}
