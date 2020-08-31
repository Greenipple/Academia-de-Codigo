package org.academiadecodigo.carcrash.cars;

public class Tank extends Car {
   // private boolean crashed = false;
    private int speed = 1;
    private boolean invulnerable = true;
    private boolean destroyInvulnerable = true;
   // private int willRevive = 0;

    @Override
    public String toString() {
        return "T";
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean isInvulnerable() {
        return invulnerable;
    }

    @Override
    public boolean isDestroyInvulnerable() {
        return destroyInvulnerable;
    }
    /*@Override
    public void revive() {
        willRevive = 2;
        }
    public void tankRevives(){
        this.crashed = false;
    }*/
    /*@Override
    public void crash(){
        this.crashed = true;
    }

    public int getWillRevive() {
        return willRevive;
    }
    public void subWillRevive(){
        willRevive--;
    }*/

   /* @Override
    public boolean isCrashed() {
        return crashed;
    }*/

}
