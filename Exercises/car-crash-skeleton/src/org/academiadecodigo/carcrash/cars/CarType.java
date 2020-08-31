package org.academiadecodigo.carcrash.cars;

public enum CarType {
    FIAT(1),
    MUSTANG(2),
    TANK(1),
    AMBULANCE(3),
    TOWTRUCK(1);

    private int speed;

    CarType(int speed) {
        this.speed=speed;
    }
    public int getSpeed(){
        return speed;
    }
}


