public class Game {


    public void init(){
        Field field = new Field();
        Player pLayer = new Player(500,250);

        field.init();
        pLayer.init();
    }
}
