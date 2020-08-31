import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private int col;
    private  int row;
    private boolean isMarked;
    private Rectangle rectangle;

    public Cell(int col, int row){

        this.col= col;
        this.row = row;
        this.rectangle = new Rectangle(col*Grid.CELLSIZE+Grid.PADDING,row*Grid.CELLSIZE+Grid.PADDING,Grid.CELLSIZE,Grid.CELLSIZE);
        rectangle.setColor(Color.BLACK);
        this.rectangle.draw();


    }

    public Cell() {

    }


    public void show(){
        this.rectangle.draw();
    }
    public void paint(){
        this.rectangle.fill();
    }

    public void hide(){
        this.rectangle.delete();
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked() {
        isMarked = !isMarked;
        if(isMarked){
            this.rectangle.fill();
        }
        else{
            this.rectangle.draw();
        }
        System.out.println(this.col + ":" +this.row);
    }
    public void mark(){
        isMarked = true;
        this.rectangle.fill();
    }
    public void unmark(){
        isMarked = false;
        this.rectangle.delete();
    }
}
