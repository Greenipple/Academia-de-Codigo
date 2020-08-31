public class Person {

    private String name;
    private double startMoneyWallet;
    private double startMoneyBank;

    private Wallet wallet;
    private Bank bank;

    public void withdraw(double amount){
        if (amount>bank.getAccountBalance()){
            System.out.println("Not enough money in your account. You can only take " + bank.getAccountBalance());
        }
        else {
            bank.withdraw(amount);
            wallet.addMoney(amount);
        }
    }
    public void deposit(double amount){
        if (amount > wallet.getWalletBalance()){
            System.out.println("You only have " + wallet.getWalletBalance() + " in your wallet");
        }
        else {
            bank.deposit(amount);
            wallet.takeMoney(amount);
        }
    }
    public double checkAccount(){
        return bank.getAccountBalance();
    }
    public double checkWallet(){
        return wallet.getWalletBalance();
    }

    //constructor:
    public Person (String name, double moneyWallet, double moneyBank){
        this.name = name;
        startMoneyWallet=moneyWallet;
        startMoneyBank=moneyBank;
        wallet = new Wallet(name,startMoneyWallet);
        bank = new Bank(name,startMoneyBank);

    }

}
