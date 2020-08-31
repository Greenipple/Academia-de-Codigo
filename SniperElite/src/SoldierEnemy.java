public class SoldierEnemy extends Enemy {

    //private int health;


    public SoldierEnemy(){
        super(100);

    }

    @Override
    public boolean isDestroyed() {
        return super.isDead();
    }
}
