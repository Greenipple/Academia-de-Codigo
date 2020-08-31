public class SniperRifle {

    private int health = 100;
    private int bulletDamage = 15;
    private boolean isDead = false;
    private int shotsFired = 0;


    public int getHealth(){
        return health;
    }
    public boolean isDead(){
        return isDead;
    }
    public void shoot(Destroyable target){

        shotsFired++;

        System.out.println("shooting");
        int random = (int)(Math.random()*10);

        if (random == 9 && target instanceof Enemy) {
            Enemy enemy  = (Enemy) target;
            System.out.println("HEAD SHOT!!!!");
            enemy.hit(bulletDamage*10,true);
        }
        else if (random > 1){
            System.out.println("Hit!");
            target.hit(bulletDamage);
        }
        else System.out.println("Miss!");


        }

    public void hit (int damage){
        health -= damage;
        if (health <=0){
            isDead = true;
        }
        else System.out.println("Ouch! You took " + damage + " damage!");

    }

    public int getShotsFired() {
        return shotsFired;
    }
}
