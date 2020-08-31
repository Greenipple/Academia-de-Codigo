package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.bootcamp.test.SimpleGfxGridTest;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid implements Grid {

    private int cols;
    private int rows;
    private int width;
    private int height;
    private int cellSize = PADDING;
    private int x = cellSize;
    private int y = cellSize;

    public static final int PADDING = 10;

    public SimpleGfxGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {
        width = cols*cellSize;
        height = rows*cellSize;
       Rectangle grid = new Rectangle( x,y,width,height);
       grid.draw();
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return cols;
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return rows;
    }

    /**
     * Obtains the width of the grid in pixels
     * @return the width of the grid
     */
    public int getWidth() {
        return width;
    }

    /**
     * Obtains the height of the grid in pixels
     * @return the height of the grid
     */
    public int getHeight() {
        return height;
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     * @return the x position of the grid
     */
    public int getX() {
        return x;
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     * @return the y position of the grid
     */
    public int getY() {
        return y;
    }

    /**
     * Obtains the pixel width and height of a grid position
     * @return
     */
    public int getCellSize() {
        return cellSize;
    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public GridPosition makeGridPosition() {
        //throw new UnsupportedOperationException();
        int posX = (int)(Math.random() * cols);
        int posY = (int)(Math.random() * rows);
        GridPosition pos = new SimpleGfxGridPosition(posX,posY,this);
        return pos;
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */
    @Override
    public GridPosition makeGridPosition(int col, int row) {
        //throw new UnsupportedOperationException();
        GridPosition pos = new SimpleGfxGridPosition(col,row, SimpleGfxGrid.this);

        return pos;
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        //throw new UnsupportedOperationException();
        y = row * cellSize + PADDING;
        return y;
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
       // throw new UnsupportedOperationException();
        x = column * cellSize + PADDING;
        return x;
    }
}
