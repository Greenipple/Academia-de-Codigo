package org.academiadecodigo.carcrash.field;

import org.academiadecodigo.carcrash.cars.Car;

public enum MoveType {
    UP("DOWN"),
    DOWN("UP"),
    LEFT("RIGHT"),
    RIGHT("LEFT");

    private boolean limit;

    private String opposite;

    MoveType(String opposite) {
        this.opposite = opposite;
    }
    public String getOpposite(){
        return opposite;
    }
}