public class Main {

    public static void main(String[] args) {

        Player player1 = new Player("Joao");
        Player player2 = new Player("Joana");
        //int maxRounds = 4;
        Game game1 = new Game();
        game1.start(player1,player2);


    }
}
