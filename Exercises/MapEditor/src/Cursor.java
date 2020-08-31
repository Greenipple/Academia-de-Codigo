import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor extends Cell{


    private Cell pos;
    private Rectangle rectangle;
    private int col;
    private int row;
    private boolean isMarking;


    public Cursor(int col, int row){
        super();
        this.col = col;
        this.row = row;
        rectangle = new Rectangle(col*Grid.CELLSIZE+Grid.PADDING,row*Grid.CELLSIZE+Grid.PADDING, Grid.CELLSIZE, Grid.CELLSIZE);
        this.rectangle.setColor(Color.GREEN);
        rectangle.fill();
    }

    public void moveUp(){
        if(this.row>0){
            row--;
            this.rectangle.translate(0,-Grid.CELLSIZE);
        }
    }

    public void moveDown(){
        if(this.row<Grid.MAXROWS-1){
            row++;
            rectangle.translate(0,Grid.CELLSIZE);
        }
    }

    public void moveLeft(){
        if(this.col>0){
            col--;
            rectangle.translate(-Grid.CELLSIZE,0);
        }
    }

    public void moveRight(){
        if(this.col<Grid.MAXCOLS-1){
            col++;
            rectangle.translate(+Grid.CELLSIZE,0);
        }
    }

    public Cell getPos() {
        return pos;
    }
    public int getCol(){
        return col;
    }
    public int getRow(){
        return row;
    }

    public boolean isMarking() {
        return isMarking;
    }

    public void startMarking() {
        isMarking = true;
    }
    public void stopMarking(){
        isMarking = false;
    }
}
