package org.academiadecodigo.carcrash.cars;

public class Mustang extends Car{
    private int speed = 3;
    public int getSpeed(){
        return speed;
    }
    @Override
    public String toString(){
        return "M";
    }
}
