package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.Car;
import org.academiadecodigo.carcrash.cars.CarFactory;
import org.academiadecodigo.carcrash.cars.Tank;
import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.MoveType;

public class Game {

    public static final int MANUFACTURED_CARS = 40;

    /** Container of Cars */
    private Car[] cars;

    /** Animation delay */
    private int delay;

    public Game(int cols, int rows, int delay) {

        Field.init(cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar();
        }

        Field.draw(cars);

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            // Move all cars
            moveAllCars();

            // Update screen
            Field.draw(cars);

        }

    }

    private void moveAllCars() {

      //  /** Counter for tank revival to protect ambulance when it revives tank*/
      /*  for (Car car : cars){
            if (car instanceof Tank){
                Tank tank = (Tank) car;
                if (tank.getWillRevive() == 2){
                    tank.subWillRevive();
                }
                else if (tank.getWillRevive() == 1){
                    tank.tankRevives();
                    tank.subWillRevive();
                }
            }
        }*/




        int maxRandom = 15;   //This sets how likely is the car to go in a straight line

        for (int i=0; i<cars.length;i++){

            Car car = cars[i];
            check4Tow(car);
            moveTowed(car);
            if (!car.isCrashed()) {
                boolean carMoved = false;
                while (!carMoved) {
                    int random;
                    if (car.getLastMove() == null) {        //this is for the first move
                        random = (int) (Math.random() * 4);
                    }
                    else{
                        random = (int) (Math.random() * maxRandom);
                    }
                    if (random > 3) {                   //This makes the car go in a straight line
                        switch (car.getLastMove()){
                            case UP -> {
                                carMovesUp(car);
                                carMoved=true;
                                break;
                            }
                            case DOWN -> {
                                carMovesDown(car);
                                carMoved=true;
                                break;
                            }
                            case LEFT -> {
                                carMovesLeft(car);
                                carMoved=true;
                                break;
                            }
                            case RIGHT -> {
                                carMovesRight(car);
                                carMoved=true;
                                break;
                            }
                        }
                    }

                    else if (random <4) {                   //This makes the car chances of going any other direction alike
                        switch (MoveType.values()[random]) {
                            case LEFT:
                                carMovesLeft(car);
                                carMoved = true;
                                break;

                            case RIGHT:
                                carMovesRight(car);
                                carMoved = true;
                                break;
                            case UP:
                                carMovesUp(car);
                                carMoved = true;
                                break;

                            case DOWN:
                                carMovesDown(car);
                                carMoved = true;
                                break;

                        }
                    }


                }


            }
            if (car.isCrashed())check4Tow(car);
            moveTowed(car);

        }

    }

                        /** Method to check for car crashes */
    private void check4Crash(Car car1){

                                //Avoid comparing with itself
            for (int i2 = 0; i2 < cars.length; i2++) {
                if(car1 == cars[i2]){
                    continue;
                }
                Car otherCar = cars[i2];
                if ((car1.getCol() == otherCar.getCol()) && (car1.getRow() == otherCar.getRow())) {
                    if (car1.isDestroyInvulnerable() && !car1.isCrashed()) otherCar.crash();     //Working Tanks destroy everything
                    if (otherCar.isDestroyInvulnerable() && !otherCar.isCrashed()) car1.crash();

                                //Tanks destroy non Tanks and get away with it
                    if (car1.isInvulnerable() && !car1.isCrashed() && !otherCar.isInvulnerable()) {
                        otherCar.crash();
                        continue;
                    }
                    if (!car1.isInvulnerable() && otherCar.isInvulnerable() && !otherCar.isCrashed()){
                        car1.crash();
                        continue;
                    }

                                //Ambulances and tow trucks go through crashed cars
                    if ((car1.isAssistCrashed() && otherCar.isCrashed()) || (otherCar.isAssistCrashed() && car1.isCrashed())){
                        continue;
                    }
                    car1.crash();
                    otherCar.crash();
                    break;
                }
            }

    }

                    /**  Check for revivals method:  */
    private void check4Revival(Car car1) {
            for (int i2 = 0; i2 < cars.length; i2++) {
                if(car1 == cars[i2]){
                    continue;
                }
                Car otherCar = cars[i2];
                if ((car1.getCol() == otherCar.getCol()) && (car1.getRow() == otherCar.getRow())) {
                    if((car1.isCanRevive() && !car1.isCrashed())) otherCar.revive();
                    if((otherCar.isCanRevive()) && !otherCar.isCrashed()) car1.revive();
                }
            }

    }



    /** Check for tow method */
    private void check4Tow(Car car1) {
        for (int i = 0; i < cars.length; i++){
            if (car1 == cars[i]){
                continue;
            }
            Car otherCar = cars[i];
            if ((car1.getCol() == otherCar.getCol()) && (car1.getRow() == otherCar.getRow())){

                /** Set the flags for towing */
                if (car1.isCanTow() && !car1.isTowing() && otherCar.isCrashed() && !otherCar.isBeingTowed()){
                    car1.setTowing(true);
                    otherCar.setBeingTowed(true);
                    otherCar.setCanTow(true);
                    car1.setCarBeingTowed(otherCar);
                }
            }
        }
    }
    /** Move towed cars */

    private void moveTowed(Car car){
        Car otherCar = car.getCarBeingTowed();
        if (car.isTowing()) {
            otherCar.getPos().setRow(car.getLastRowPos());
            otherCar.getPos().setCol(car.getLastColPos());
            otherCar.setLastRowPos(otherCar.getPos().getRow());
            otherCar.setLastColPos(otherCar.getPos().getCol());
        }
    }



                /**Move methods */
    private void carMovesLeft(Car car){
        for (int iL = 0; iL < car.getSpeed(); iL++) {
            if ((car.getLastMove() != MoveType.RIGHT) && (car.getPos().getCol() > 0)) {
                    //remember last position
                    car.setLastColPos(car.getPos().getCol());
                    car.setLastRowPos(car.getPos().getRow());

                    car.getPos().moveLeft();
                    check4Crash(car);
                    check4Revival(car);
                    check4Tow(car);
                    car.setLastMove(MoveType.LEFT);

                }

            }

    }
    private void carMovesRight(Car car){
        for (int iR = 0; iR < car.getSpeed(); iR++) {
            if ((car.getLastMove() != MoveType.LEFT) && (car.getPos().getCol() < Field.getWidth() - 1)) {
                   // remember last position
                    car.setLastColPos(car.getPos().getCol());
                    car.setLastRowPos(car.getPos().getRow());

                    car.getPos().moveRight();
                    check4Crash(car);
                    check4Revival(car);
                    check4Tow(car);
                    car.setLastMove(MoveType.RIGHT);
                }

            }
    }
    private void carMovesUp(Car car){
        for (int iU = 0; iU < car.getSpeed(); iU++) {
            if ((car.getLastMove() != MoveType.DOWN) && (car.getPos().getRow() > 0)) {
                    //remember last position
                    car.setLastColPos(car.getPos().getCol());
                    car.setLastRowPos(car.getPos().getRow());

                    car.getPos().moveUp();
                    check4Crash(car);
                    check4Revival(car);
                    check4Tow(car);
                    car.setLastMove(MoveType.UP);
                }

            }
    }
    private void carMovesDown(Car car){
        for (int iD = 0; iD < car.getSpeed(); iD++) {
            if ((car.getLastMove() != MoveType.UP) && (car.getPos().getRow() < Field.getHeight() - 1)) {
                   // remember last position
                    car.setLastColPos(car.getPos().getCol());
                    car.setLastRowPos(car.getPos().getRow());

                    car.getPos().moveDown();
                    check4Crash(car);
                    check4Revival(car);
                    check4Tow(car);
                    car.setLastMove(MoveType.DOWN);
                }

            }
    }
}
