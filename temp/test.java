package temp;
import java.util.Random;

class test{
    public static void wait(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void print_text(String str){
        for (int i = 0; i<str.length();i++) {
            System.out.print(str.charAt(i));
            wait(70);
        }
        System.out.println(" ;)");
        wait(2000);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    public static void main(String[] args){
        print_text("hello there, welcome to the death game");
        
    }
}