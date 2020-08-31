public class RandomBetween {


    public static int please(int input1,  int input2) {
        double difference = Math.abs (input1-input2)+1;
        double random = Math.random()*difference + Math.min(input1,input2);
        int answer = (int)random;
        return answer;
    }
}
