import java.util.Random;
import java.util.Scanner;
//for suggling arrays
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
////////////////////////////////Gun class/////////////////////////////////////////////////////////
class Gun{
    int current_index = 0;
    public boolean[] generate_mag(int blanks, int lives){
        boolean[] mag = new boolean[blanks+lives];
        for (int i = 0; i < lives; i++) {
            mag[i] = true;
        }
        //suffling array
        List<Boolean> booleanList = new ArrayList<>();
        for (boolean b : mag) {
            booleanList.add(b);
        }
        Collections.shuffle(booleanList);
        for (int i = 0; i < mag.length; i++) {
            mag[i] = booleanList.get(i);
        }
        return mag;
    }
    public void shoot(Player player){
        player.health--;
    }
}
//////////////////////////////////Player class/////////////////////////////////////////////////////////
class Player{
        int health = 4;
        int[] inventory = new int[8];
    }
////////////////////////////////////Main Class////////////////////////////////////////////////////////
public class Game {
    //Function to halt the excution of the code
    public static void wait(int millisecond){
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //clearing screen
    public static void clrscr(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    //steady printing of texts
    public static void print_text(String str,int pause_duration){
        for (int i = 0; i<str.length();i++) {
            System.out.print(str.charAt(i));
            wait(70);
        }
        System.out.println();
        wait(pause_duration);
        clrscr();
    }
    /*public boolean[] new_ammo(int bullet_count){
        
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
    }*/
    public static void main(String[] args) {
        Player player_1 = new Player();
        Player player_2 = new Player();
        Gun gun = new Gun();
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        clrscr();
        //game start and explaining rules to player
        //Round one starts here
        print_text("Welcome player...",2000);
        print_text("We have been awaiting you...",2000);
        print_text("But before we begin, \nWe must look at the rules of the GAME.",2000);
        print_text("Here are the rules:"
        +"\n1. You can either shoot yourself or the dealer,"
        +"\n2. If you shoot yourself with a blank round you get one more change."
        +"\n3. New rules will be introduced as you further progress in the game."
        +"\n3. If you lose all lives, you are dead, if you quit you are dead. Only way to survive is to win.",5000);
        System.out.println("You ready??");
        sc.next();
        print_text("Doesn't matter, let's start", 2000);

    }
}
