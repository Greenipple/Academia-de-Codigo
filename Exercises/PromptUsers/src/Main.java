import java.util.HashSet;
import java.util.LinkedList;

public class Main {

    private HashSet<User> usersList = null;
    private UserInterface userInterface;

    public static void main(String[] args) {
        Main main = new Main();
        main.initialize();
        main.userInterface.run();



    }

    public void initialize(){

        usersList = new HashSet<User>();

        UserHandler userHandler = new UserHandler(usersList);

        userInterface = new UserInterface(userHandler);

        usersList.add(new User("Patricio","TakeOffYourClothes"));
        usersList.add(new User("Tiago","SexyBeast"));
        usersList.add(new User("Presidente","porra"));

    }
}
