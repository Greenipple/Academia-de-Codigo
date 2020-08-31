package org.academiadecodigo.carcrash.cars;

public class CarFactory {

    public static  Car getNewCar() {
        Car newCar = null;
        int random = (int) (Math.random() * 5);
        switch (CarType.values()[random]) {
            case FIAT:
                newCar = new Fiat();
                return newCar;
            case MUSTANG:
                newCar = new Mustang();
                return newCar;
            case TANK:
                newCar = new Tank();
                return newCar;
            case AMBULANCE:
                newCar = new Ambulance();
                return newCar;
            case TOWTRUCK:
                newCar = new TowTruck();

        }
        return newCar;
    }
}
