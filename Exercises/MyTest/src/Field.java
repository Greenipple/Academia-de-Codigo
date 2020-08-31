import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {


    int fieldHeight = 500;
    int fieldWidth = 1000;

public void init(){

    Rectangle field = new Rectangle(10,10,fieldWidth,fieldHeight);
    field.draw();
}
}
