public class Lamp {

    private int maxNrGenies;
    private int remainingGenies;
    private int geniesCreated;
    private int timesRecharged;
    private boolean demonExists;


    public Genie rub(int wishes){
        if (remainingGenies <= 0){
            System.out.println("A demon appears!");
            demonExists=true;
            geniesCreated++;
            remainingGenies--;
            return new Demon(wishes);
        }
        else if (geniesCreated % 2 == 0) {
            System.out.println("A friendly genie appears!");
            geniesCreated++;
            remainingGenies--;
            return new FriendlyGenie(wishes);
        }
        else {
            System.out.println("A grumpy genie appears!");
            geniesCreated++;
            remainingGenies--;
            return new GrumpyGenie(wishes);
        }
    }

    public void recharge(Demon demon){
        if(!(demon instanceof Demon)){
            return;
        }
        if(!demon.getRecycled()&&demonExists) {
            System.out.println("Demon recycled, Lamp recharged");
            timesRecharged++;
            demonExists=false;
            demon.recycle();
            remainingGenies = maxNrGenies;
        }
        else {
            System.out.println("No recharge possible.");
        }
    }

    public Lamp(int maxNrGenies){
        this.maxNrGenies = maxNrGenies;
        remainingGenies = maxNrGenies;
    }

    /*public void compare(Lamp lampToCompare){
        boolean capacity = this.maxNrGenies==lampToCompare.maxNrGenies;
        boolean remainingGenies = this.remainingGenies==lampToCompare.remainingGenies;
        boolean timesRecharged = this.timesRecharged==lampToCompare.timesRecharged;
        System.out.println("capacity: " + capacity);
        System.out.println("remaining genies: " + remainingGenies);
        System.out.println("Times recharged: " + timesRecharged);*/
    public boolean compare(Lamp lampToCompare){
        return ((this.maxNrGenies==lampToCompare.maxNrGenies)&&
                (this.remainingGenies==lampToCompare.remainingGenies)&&
                (this.timesRecharged==lampToCompare.timesRecharged));

    }
}
