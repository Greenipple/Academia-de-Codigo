public class GrumpyGenie extends Genie {

    public GrumpyGenie(int maxWishes) {
        super(maxWishes);
    }

    @Override
    public void grantWish() {
      if (getWishesGranted() == 0){
          System.out.println("Your wish is granted!");
          addWishesGranted();
      }
      else {
          System.out.println("You ran out of wishes!");
      }
    }
}
