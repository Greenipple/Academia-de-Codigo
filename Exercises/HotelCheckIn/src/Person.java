public class Person {

    private Hotel hotel = new Hotel();
    private int keyNumber = 99;

    public void ask2CheckIn(){
        keyNumber=hotel.checkIn();
    }
    public void ask2CheckOut(){
        if (keyNumber == 99){
            System.out.println("I don't recall ever checking in anywhere!");
        }
        else hotel.checkOut(keyNumber);
    }
}
