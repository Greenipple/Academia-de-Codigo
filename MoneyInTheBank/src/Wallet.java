public class Wallet {

    private double money;
    private String name;

    public void addMoney(double amount){
        money += amount;
    }
    public void takeMoney(double amount){
        money -= amount;
    }

    public double getWalletBalance(){
        return money;
    }

    public Wallet(String name,double money){
        this.name = name;
        this.money = money;
    }
}
