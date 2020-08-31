public class Bank {

    private double money;
    private String name;

    public void deposit(double amount){
        money += amount;
        System.out.println("You have deposited " + amount + " Thank you for your money.");
    }
    public void withdraw(double amount){
        money -= amount;
        System.out.println("You have withdrawned " + amount);
    }
    public double getAccountBalance(){
        return money;
    }

    public Bank(String name,double money){
        this.name = name;
        this.money = money;
    }
}
