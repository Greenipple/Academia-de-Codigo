public class Game {

    private GameObject[] objects;
    private SniperRifle myGun = new SniperRifle();
    private Boss boss = new Boss();

   //Create an array of objects
    public void createObjects(int amount){
        objects = new GameObject[amount];
        GameObject newObject = null;

        for (int i = 0; i < objects.length; i++){
            double random = Math.random()*100;

             int chance4Tree = 25;
             int chance4Armoured = 30;          //Chances from 100%
             int chance4Soldier = 30;
                //remaining is chance for barrel

            if (random < chance4Tree){
                newObject = new Tree();
            }


            else if(random < chance4Tree + chance4Armoured){
                newObject = new ArmouredEnemy();
            }


            else if(random < chance4Tree + chance4Armoured + chance4Soldier){
                newObject = new SoldierEnemy();
            }

            else {
                newObject = new Barrel();
            }
            objects[i] = newObject;
            //System.out.println(newObject.getMessage());
        }

    }

    public void start() {
        System.out.println("start");

        for (GameObject object : objects) {
            System.out.println(object.getMessage());

            if (object instanceof Enemy) {
                Enemy target = (Enemy) object;
                System.out.println(target.getHealth());

                while (!target.isDead()) {
                    myGun.shoot(target);
                }
            } else if (object instanceof Destroyable) {
                Destroyable target = (Destroyable) object;

                while (!target.isDestroyed()) {
                    myGun.shoot(target);
                }

            }
        }

            System.out.println(boss.getMessage());

            while (!boss.isDead()) {
                myGun.shoot(boss);

                if (boss.isDead()) {
                    System.out.println("You Killed the Boss!!");
                    return;
                }

                boss.shoot(myGun);
                if (myGun.isDead()) {
                    System.out.println("YOU DIED!!!!! Please insert coin");
                    return;
                }
                System.out.println("Your health is " + myGun.getHealth());
                System.out.println("BigBoss health is " + boss.getHealth());
                System.out.println(("BigBadBoss armour is " + boss.getArmour()));

            }
        }



    public int getShotsFired(){
        return myGun.getShotsFired();
    }
}
