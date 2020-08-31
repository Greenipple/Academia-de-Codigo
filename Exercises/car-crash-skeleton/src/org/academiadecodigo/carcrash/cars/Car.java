package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.MoveType;
import org.academiadecodigo.carcrash.field.Position;

abstract  public class Car {

    /** The position of the car on the grid */

    private Position pos = new Position();

    private MoveType lastMove;
    private boolean crashed = false;
    private boolean invulnerable;
    private boolean destroyInvulnerable;
    private boolean assistCrashed;
    private boolean canRevive;
    private int speed;


                /** Towing variables*/
    private boolean canTow;
    private boolean towing;
    private boolean beingTowed;
    private Car carBeingTowed;
    private int carBeingTowedIndex;
    private int lastRowPos;
    private int lastColPos;


                /**Get car position on the field*/
    public int getCol(){
        return pos.getCol();
    }
    public int getRow(){
        return pos.getRow();
    }
    public Position getPos() {
        return pos;
    }

                /** check if the car is crashed and crash it or fix it*/
    public boolean isCrashed() {
        return crashed;
    }
    public void crash(){
        crashed = true;
    }
    public void revive(){
        crashed = false;
    }


                    /** car speed and movement */
    public MoveType getLastMove(){
        return lastMove;
    }
    public void setLastMove(MoveType lastMove){
        this.lastMove=lastMove;
    }

    public abstract int getSpeed();


    /** Other stuff like super-powers and special characteristics */

   public boolean isInvulnerable(){
       return invulnerable;
   }
   public boolean isCanRevive(){
       return canRevive;
   }
   public boolean isDestroyInvulnerable(){
       return destroyInvulnerable;
   }
   public boolean isAssistCrashed(){
       return assistCrashed;
   }


            /** Towing setters and getters */

    public boolean isCanTow() {
        return canTow;
    }
    public void setCanTow(boolean canTow) {
        this.canTow = canTow;
    }
    public boolean isTowing() {
        return towing;
    }
    public void setTowing(boolean towing) {
        this.towing = towing;
    }
    public boolean isBeingTowed() {
        return beingTowed;
    }
    public void setBeingTowed(boolean beingTowed) {
        this.beingTowed = beingTowed;
    }
    public Car getCarBeingTowed() {
        return carBeingTowed;
    }
    public void setCarBeingTowed(Car carBeingTowed) {
        this.carBeingTowed = carBeingTowed;
    }
    public int getCarBeingTowedIndex() {
        return carBeingTowedIndex;
    }
    public void setCarBeingTowedIndex(int carBeingTowedIndex) {
        this.carBeingTowedIndex = carBeingTowedIndex;
    }
    public int getLastRowPos() {
        return lastRowPos;
    }
    public void setLastRowPos(int lastRowPos) {
        this.lastRowPos = lastRowPos;
    }
    public int getLastColPos() {
        return lastColPos;
    }
    public void setLastColPos(int lastColPos) {
        this.lastColPos = lastColPos;
    }
}






