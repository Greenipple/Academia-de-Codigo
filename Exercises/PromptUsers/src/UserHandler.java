import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class UserHandler {

    private HashSet<User> usersList;

    public UserHandler(HashSet usersList){
        this.usersList = usersList;
    }

    public Set getNames(){

        Set<String> namesList = new HashSet<>();

        for(User user: usersList){
            namesList.add(user.getName());
        }

        return namesList;
    }

    public boolean checkPassword(String userName, String password){

        for(User user: usersList){
            if(user.getName().equals(userName) && user.getPassword().equals(password)){
                user.loggIn();
                return true;
            }
        }
        return false;
    }
}
