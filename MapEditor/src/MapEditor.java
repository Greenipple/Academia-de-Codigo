import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MapEditor implements KeyboardHandler {



    private Grid grid;
    private Cursor cursor;
    private Keyboard keyboard;
    private SaveManager saveManager;


    public void init(){
        grid = new Grid();
        grid.show();
        cursor = new Cursor(1,1);
        keyboard = new Keyboard(this);
        saveManager = new SaveManager();
        saveManager.setGrid(grid);
        //cursor.show();

        KeyboardEvent l = new KeyboardEvent();
        l.setKey(KeyboardEvent.KEY_L);
        l.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent s = new KeyboardEvent();
        s.setKey(KeyboardEvent.KEY_S);
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent stopWriting = new KeyboardEvent();
        stopWriting.setKey(KeyboardEvent.KEY_SPACE);
        stopWriting.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(space);
        keyboard.addEventListener(s);
        keyboard.addEventListener(l);
        keyboard.addEventListener(stopWriting);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
               cursor.moveLeft();
                if (cursor.isMarking()) {
                    grid.mark(cursor.getCol(),cursor.getRow());
                    break;
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
               cursor.moveRight();
                if (cursor.isMarking()) {
                    grid.mark(cursor.getCol(),cursor.getRow());
                    break;
                }
                break;
            case KeyboardEvent.KEY_UP:
               cursor.moveUp();
                if (cursor.isMarking()) {
                    grid.mark(cursor.getCol(),cursor.getRow());
                    break;
                }
                break;
            case KeyboardEvent.KEY_DOWN:
               cursor.moveDown();
                if (cursor.isMarking()) {
                    grid.mark(cursor.getCol(),cursor.getRow());
                    break;
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                cursor.startMarking();
                grid.mark(cursor.getCol(),cursor.getRow());
                break;
            case KeyboardEvent.KEY_S:
                System.out.println("save");
                try {
                    saveManager.save();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case KeyboardEvent.KEY_L:
                System.out.println("load");
                try {
                    saveManager.load();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            cursor.stopMarking();
            System.out.println("stop marking");
        }

    }
}
