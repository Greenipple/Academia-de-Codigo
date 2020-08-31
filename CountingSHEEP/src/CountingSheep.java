import java.util.Arrays;

public class CountingSheep {

   static String[] herd = new String[100];

    public static void main(String[] args) {
        Herd.paintAll("White");
        Herd.paintRandom1("Black");
        Herd.countThem();
        Herd.paintAll("Pink");
    }
}
