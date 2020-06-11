public class Genie {

    private int maxWishes;
    private int wishesGranted;

    public void grantWish(){
        if (wishesGranted < maxWishes) {
            System.out.println("Your wish is granted!");
            wishesGranted++;
        }
        else {
            System.out.println("You ran out of wishes!");
        }
    }
    /*public void recycle(){
        System.out.println("No demon to recycle");
    }*/
    public int getWishesGranted(){
        return wishesGranted;
    }
    public void addWishesGranted(){
        wishesGranted++;
    }
    public Genie(int maxWishes){
        this.maxWishes = maxWishes;
    }

}
