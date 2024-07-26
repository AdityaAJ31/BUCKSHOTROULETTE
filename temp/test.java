package temp;
import java.util.Random;

class test{
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(rand.nextInt(3));
        }
    }
}