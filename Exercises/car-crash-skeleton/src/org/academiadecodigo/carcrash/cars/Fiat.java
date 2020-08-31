package org.academiadecodigo.carcrash.cars;

import com.googlecode.lanterna.terminal.Terminal;

public class Fiat extends Car {
    private int speed =1;
    public int getSpeed(){
        return speed;
    }
    @Override
    public String toString(){
        return "F";
    }
}
