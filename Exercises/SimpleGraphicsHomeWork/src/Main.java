import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {



        for (int i=0; i<10; i++) {
            Rectangle[] rectangle = new Rectangle[10];

            for (int i2 = 0; i2 < 10; i2++) {
                rectangle[i2] = new Rectangle(10 + i2 * 60, 10+i*60, 50, 50);
                rectangle[i2].setColor(new Color(i*15, 125, i2 * 15));
                rectangle[i2].fill();
            }
        }



    }
}
