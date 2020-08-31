public class Player {

    private String name;
    private int points;

    public int getPoints() {
        return points;
    }
    public String getName() {
        return name;
    }

    public Player(int points){
        this.points = points;
    }

    public Player(String name) {
        this.name = name;
    }

    public void addPoint() {
        this.points++;
    }

    public RpsType guess(){
        int randomNr= (int) (Math.random() * 3);
        return RpsType.values()[randomNr];
    }
}
