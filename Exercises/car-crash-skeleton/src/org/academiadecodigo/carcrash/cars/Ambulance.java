package org.academiadecodigo.carcrash.cars;

import com.googlecode.lanterna.terminal.Terminal;

import static com.googlecode.lanterna.terminal.Terminal.Color.WHITE;

public class Ambulance extends Car {
    private int speed = 3;
    private boolean invulnerable = false;
    private boolean canRevive = true;
    private boolean assistCrashed = true;

    @Override
    public String toString(){
        return "+";
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
    public boolean isCanRevive() {
        return canRevive;
    }

    @Override
    public boolean isAssistCrashed() {
        return assistCrashed;
    }
}
