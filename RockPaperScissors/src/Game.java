public class Game {

    private int maxRounds = 4;
    private int currentRound = 0;
    public void start(Player player1, Player player2){
        while (currentRound < maxRounds) {
            System.out.println(player1.getName() + " : " +player1.getPoints());
            System.out.println(player2.getName() + " : " +player2.getPoints());
            RpsType p1guess = player1.guess();
            RpsType p2guess = player2.guess();
            System.out.println(player1.getName() +" chooses " + p1guess);
            System.out.println(player2.getName() + " chooses " + p2guess);
            if (p1guess == p2guess) {
                currentRound++;
                continue;
            }
            else if (p1guess.getWinsTo() == p2guess.ordinal()){
                player1.addPoint();
            }
            else if (p1guess.getLosesTo() == p2guess.ordinal()){
                player2.addPoint();
            }
            currentRound++;

            /*
            else if (p1guess == RpsType.ROCK){
                if (p2guess == RpsType.PAPER){
                    player2.addPoint();
                }
                else if (p2guess == RpsType.SCISSORS){
                    player1.addPoint();
                }
                currentRound++;
                continue;
            }
            else if (p1guess == RpsType.PAPER){
                if (p2guess == RpsType.SCISSORS) {
                    player2.addPoint();
                }
                else if (p2guess == RpsType.ROCK) {
                    player1.addPoint();
                }
                currentRound++;
                continue;
            }
            else if (p1guess == RpsType.SCISSORS){
                if (p2guess == RpsType.ROCK){
                    player2.addPoint();
                }
                else if (p2guess == RpsType.PAPER){
                    player1.addPoint();
                }
                currentRound++;
                continue;
            }*/
        }
        if (player1.getPoints() == player2.getPoints()){
            System.out.println("It's a Draw......"+player1.getPoints()+" : "+player2.getPoints());
        }

        else if (player1.getPoints() > player2.getPoints()){
            System.out.println(player1.getName()+ " Wins! "+player1.getPoints()+" : "+player2.getPoints());
        }
        else if (player1.getPoints() < player2.getPoints()){
           System.out.println(player2.getName() + " Wins! "+player1.getPoints()+" : "+player2.getPoints());
        }




    }

}
