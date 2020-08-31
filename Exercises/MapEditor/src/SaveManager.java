import java.io.*;

public class SaveManager {


    private static final String PATH = "resources/save.txt";

    private Grid grid;


    public void save() throws IOException {

        String line = "";

        FileWriter output = null;
        BufferedWriter bf = null;
        try {

            for (int y=0; y<grid.MAXROWS; y++) {


                for (int x = 0; x < grid.MAXCOLS; x++) {

                    if (grid.getCellArray()[x][y].isMarked()) {
                        line += "X";
                    } else {
                        line += "O";
                    }
                    if(x==grid.MAXCOLS-1){
                        line+="\n";
                    }

                }
                output = new FileWriter(PATH);
                bf=new BufferedWriter(output);

                System.out.println("saving : " + line);
                bf.write(line+"\n");
                bf.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void load() throws FileNotFoundException {
        FileReader reader = null;
        BufferedReader bReader = null;



        try{
            reader= new FileReader(PATH);
            bReader = new BufferedReader(reader);


            for (int y=0; y<grid.MAXROWS;y++ ){
                String content = "";
                content += bReader.readLine()+"\n";

                for (int x=0; x<grid.MAXCOLS; x++){

                    char character = content.charAt(x);
                    if(character == 88){
                        grid.getCellArray()[x][y].mark();
                    }else{
                        grid.getCellArray()[x][y].unmark();
                    }

                }
            }
            bReader.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

}
