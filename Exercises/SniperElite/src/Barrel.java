public class Barrel extends GameObject implements Destroyable {


    private BarrelType type;
    private int currentDamage;
    private boolean destroyed;


    public Barrel(){
        int index = (int)(Math.random()*(BarrelType.values().length));
        type = BarrelType.values()[index];
    }


    public void hit(int damage){
        System.out.println("Barrel took " + damage + "damage");
        currentDamage += damage;
        if (currentDamage >= type.getMaxDamage()){
            destroyed = true;
            System.out.println("Barrel " + type +" destroyed");
        }
    }
    public boolean isDestroyed(){
        return destroyed;
    }
    public  String getMessage(){
        return "This is a " +type + " barrel";
    }

}
