public class Grid {

    public static final int CELLSIZE = 30;
    public static final int MAXCOLS = 20;
    public static final int MAXROWS = 20;
    public static final int PADDING = 10;

    private Cell cell;
    private Cell[][] cellArray = new Cell[MAXCOLS][MAXROWS];

    public void show(){
        for (int x =0; x<MAXCOLS; x++){
            for(int y=0; y<MAXROWS; y++){
                cellArray[x][y] = new Cell(x,y);
                cellArray[x][y].show();
            }
        }

    }

    public void mark(int col, int row){
        cellArray[col][row].setMarked();
    }

    public Cell[][] getCellArray(){
        return cellArray;
    }
}
