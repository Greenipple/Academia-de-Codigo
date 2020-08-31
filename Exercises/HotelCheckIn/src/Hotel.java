import java.util.Arrays;

public class Hotel {

    private Room[] room = new Room[5];

    private int freeRoomKey;
    public Hotel(){
        for (int i=0; i<5; i++){
            room[i]=new Room();
        }
        room[0].setOccupied(true);
        room[1].setOccupied(true);
        room[2].setOccupied(false);
        room[3].setOccupied(true);
        room[4].setOccupied(true);
    }
    public boolean checkEmptyRooms(){
        for (int i=0; i<room.length; i++){
            if (room[i].getOccupied() == false) {
                freeRoomKey = i;
                return true;
            }
        }
        return false;
    }
    public int checkIn(){
        if (!checkEmptyRooms()) {
            System.out.println("I'm terribly sorry, sir. We have no available rooms at the moment. So please BUGGER OFF!!!");
            return 99;
        }
        else {
            System.out.println("We have room number " + freeRoomKey + " ready for you.");
            room[freeRoomKey].setOccupied(true);
            return freeRoomKey;
        }
    }
    public void checkOut(int key){
        room[key].setOccupied(false);
        System.out.println("Checking out...");
    }

}
