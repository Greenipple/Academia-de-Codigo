public class PlayGround {
    public static void main(String[] args) {

        Person person = new Person("Ambrosio",25.0,1000.0);
        System.out.println(person.checkAccount());
        System.out.println(person.checkWallet());
        person.deposit(30);
        person.withdraw(500);
        System.out.println(person.checkWallet());
        person.withdraw(10000000);
    }
}
