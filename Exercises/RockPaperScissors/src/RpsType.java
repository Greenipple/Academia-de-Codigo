public enum  RpsType {
    ROCK(2,1),
    PAPER(0,2),
    SCISSORS(1,0);

    private int winsTo;
    private int losesTo;

    private RpsType(int winsTo, int losesTo) {
        this.winsTo=winsTo;
        this.losesTo=losesTo;
    }
    public int getWinsTo(){
        return winsTo;
    }
    public int getLosesTo(){
        return losesTo;
    }



}
