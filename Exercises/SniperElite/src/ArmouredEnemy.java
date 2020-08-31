public class ArmouredEnemy extends Enemy {

    private int armour = 150;

    public ArmouredEnemy() {
        super(100);
    }

    @Override
    public void hit(int damage){
        if (armour > 0){
            armour -= damage;
            System.out.println("You hit the enemy armour and caused " + damage + " damage");
        }

        else {
            super.hit(damage);
        }
    }

    @Override
    public boolean isDestroyed() {
        return super.isDead();
    }

    @Override
    public void hit (int damage, boolean headShot){
        if (headShot){
            super.hit(damage);  //head shots bypass armour
        }
        else{
            hit(damage);
        }
    }
}
