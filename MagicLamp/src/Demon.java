public class Demon extends Genie {
    public Demon(int maxWishes){
        super(maxWishes);
    }

    private boolean recycled;

    @Override
    public void grantWish() {
        System.out.println("Your wish is granted!");
        addWishesGranted();
    }

    public void recycle(){
        recycled = true;
    }

    public boolean getRecycled(){
        return recycled;
    }
}
