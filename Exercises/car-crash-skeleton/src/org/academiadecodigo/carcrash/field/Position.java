package org.academiadecodigo.carcrash.field;

public class Position {

    private int col = (int)(Math.random()*Field.getWidth());
    private int row = (int)(Math.random()*Field.getHeight());

    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }

    public void moveRight(){
            col++;
    }
    public void moveLeft(){
            col--;
    }
    public void moveUp(){
            row--;
    }
    public void moveDown(){
            row++;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
