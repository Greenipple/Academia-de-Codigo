public class Teste {
    public static void main(String[] args) {
        System.out.println(RpsType.values()[1]);
        System.out.println(RpsType.values()[RpsType.SCISSORS.getWinsTo()]);
        System.out.println(RpsType.SCISSORS.getWinsTo());
        System.out.println(5==2);
        System.out.println(RpsType.PAPER.ordinal());
    }
}
