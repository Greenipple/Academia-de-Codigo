public enum BarrelType {

    PLASTIC (20),
    WOOD(30),
    METAL(90);

    int maxDamage;

    BarrelType(int maxDamage){
        this.maxDamage = maxDamage;
    }
    public int getMaxDamage(){
        return maxDamage;
    }
}
