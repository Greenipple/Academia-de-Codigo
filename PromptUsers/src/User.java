public class User {

    private String name;
    private String password;
    private boolean loggedIn;

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }



    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void loggIn(){
        loggedIn = true;
    }
}
