public abstract class Enemy extends GameObject implements Destroyable{


    private int health;
    private boolean isDead = false;

    public Enemy(int health){
        this.health = health;
    }

    public boolean isDead() {
        return isDead;
    }
    public void hit(int damage){
        System.out.println("you hit him/her! Enemy took " + damage + " damage");
        health -= damage;
        if (health <= 0){
            isDead = true;
            System.out.println("YOU KILLED HIM/HER!");
        }
    }
    public void hit(int damage, boolean headShot){
        hit(damage);
    }

    public  void kill(){
        isDead = true;
    }

    @Override
    public String getMessage(){
        return "Found an enemy!";
    }

    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }

}
