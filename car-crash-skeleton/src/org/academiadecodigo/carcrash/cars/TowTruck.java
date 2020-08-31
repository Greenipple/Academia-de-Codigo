package org.academiadecodigo.carcrash.cars;

public class TowTruck extends Car{
    private int speed = 1;
    private boolean assistCrashed = true;
    private boolean canTow = true;
    /*private boolean towing;
    private boolean beingTowed;
    private Car carBeingTowed;
    private int carBeingTowedIndex;
    private int lastRowPos;
    private int lastColPos;*/


    @Override
    public String toString(){
        return "O";
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean isAssistCrashed() {
        return assistCrashed;
    }

    @Override
    public boolean isCanTow() {
        return canTow;
    }
}
