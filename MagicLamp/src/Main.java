import com.sun.tools.attach.AgentInitializationException;

public class Main {
    public static void main(String[] args) {
        Lamp magicLamp = new Lamp(3);
        for (int i=0; i<6; i++){
            Genie genie = magicLamp.rub(2);
            for (int i2 = 0; i2 < 4; i2++) {
                genie.grantWish();
                }
            }
        Genie genie = magicLamp.rub(2);
        magicLamp.recharge((Demon) genie);
        magicLamp.recharge((Demon) genie);
        genie = magicLamp.rub(2);
        Lamp lamp2 = new Lamp(3);
        System.out.println(magicLamp.compare(lamp2));
        if (genie instanceof Demon) {
            magicLamp.recharge((Demon) genie);
        }

        }
}
