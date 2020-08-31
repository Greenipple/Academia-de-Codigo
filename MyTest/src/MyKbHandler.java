

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

//Useful
public class MyKbHandler implements KeyboardHandler {


    private Rectangle rectangle;

    public MyKbHandler(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()){
            case KeyboardEvent.KEY_LEFT:
                rectangle.translate(-10,0);

                break;

            case KeyboardEvent.KEY_RIGHT:
                rectangle.translate(10,0);

                break;

            case KeyboardEvent.KEY_DOWN:
                rectangle.translate(0,10);
                break;

             case KeyboardEvent.KEY_UP:
                 rectangle.translate(0,-10);
                 break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}