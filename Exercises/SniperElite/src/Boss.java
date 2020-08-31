public class Boss extends Enemy{


    private int armour =500;
    private int gunDamage = 10;

    public Boss() {
        super(500);
    }

    @Override
    public String getMessage(){
        return "Here comes the BOSS!!! UH AH AH AH AAH! I'm gonna melt you down";
    }

    @Override
    public void hit(int damage) {

        if (armour > 0) {
            armour -= damage;
            System.out.println("You hit the Bosse's armour and caused " + damage + " damage to armour");
            if (armour < 0) {
                armour = 0;
            }
        } else {
            System.out.println("Boss took " + damage + " damage");
            Boss.super.setHealth(Boss.super.getHealth()-damage);
            if (Boss.super.getHealth() <= 0){
                kill();
            }
        }
    }

    @Override
    public boolean isDestroyed() {
        return super.isDead();
    }


    @Override
        public void hit ( int damage, boolean headShot){
            if (headShot) {
                System.out.println("He took "+damage);
                Boss.super.setHealth(Boss.super.getHealth()-damage);   //head shots bypass armour
                if (Boss.super.getHealth() <=0 ){
                    kill();
                }
            }

            else {
                this.hit(damage);
            }
        }

        public void shoot (SniperRifle myGun){
            System.out.println("Take this! HU HU HAHAHAHA!");
            int random = (int) (Math.random() * 5);
            if (random == 0) {
                myGun.hit(gunDamage);
            } else System.out.println("He missed you!");
        }

        public int getArmour () {
            return armour;
        }
}

