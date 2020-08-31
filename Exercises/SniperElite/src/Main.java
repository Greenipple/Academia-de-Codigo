public class Main {
    public static void main(String[] args) {


        Game g = new Game();
        g.createObjects(20);
        g.start();
        System.out.println("shots fired: "+ g.getShotsFired());

    }
}
