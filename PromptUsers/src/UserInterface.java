import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;

public class UserInterface {

    private Prompt prompt;
    private UserHandler userHandler;
    private String username;



    public UserInterface(UserHandler userHandler){
        this.prompt = new Prompt(System.in,System.out);
        this.userHandler = userHandler;
    }

    public void run(){

        StringSetInputScanner askName = new StringSetInputScanner(userHandler.getNames());
        askName.setMessage("Please enter user name:");
        askName.setError("User not found.");

        PasswordInputScanner askPassword = new PasswordInputScanner();
        askPassword.setMessage("Please enter password:");
        askPassword.setError("Not a valid password!");

        username = prompt.getUserInput(askName);

        while(!userHandler.checkPassword(username,prompt.getUserInput(askPassword))){
            System.out.println("Wrong password!");
        }
        System.out.println("Welcome "+ username + " :)");
    }
}
