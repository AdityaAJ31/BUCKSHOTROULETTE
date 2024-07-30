package dev;
import java.util.Random;

public class Game {
    //Function to take breaks, enter milliseconds for parameters 
    public static void wait(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //clearing screen
    public static void clrscr(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    //steady printing of texts
    public static void print_text(String str){
        for (int i = 0; i<str.length();i++) {
            System.out.print(str.charAt(i));
            wait(70);
        }
        System.out.println();
        wait(2000);
        clrscr();
    }
    public boolean[] new_ammo(int bullet_count){
        
        Random rand = new Random();
        boolean[] magzine = new boolean[bullet_count];
        //random number
        int x = rand.nextInt( (int)Math.ceil((double)bullet_count/2));
        
        //debugging purposes
        System.out.println("roundof values"+(int)Math.ceil((double)bullet_count/2));
        System.out.println("bullet count / 2 : "+bullet_count/2);
        System.err.println(x);

        //magzine must contain about have of the ammo of real rounds
        for(int i = 0;i < bullet_count/2 + (x);i++){
            magzine[i] = true;
        }
        return magzine;
    }
    public static void main(String[] args) {
        Game obj = new Game();
        for (boolean i : obj.new_ammo(8)) {
            
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
