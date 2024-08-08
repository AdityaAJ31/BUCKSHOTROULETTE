package dev.temp;

import java.util.Scanner;

public class turn {
    public static int bool_to_int(boolean a){
        if (a)
            return 1;
        return 0;
    }
    public static void main(String[] args) {
        boolean player_turn = true;
        Scanner sc = new Scanner(System.in);
        boolean chain = false;
        // each representing health of two players
        int[] health = {5,5};

        while(true){
            System.out.println("Turn = "+ bool_to_int(player_turn));
            System.out.print("Enter target_self: ");
            boolean target_self = sc.nextBoolean();
            System.out.print("Enter bullet type: ");
            boolean round = sc.nextBoolean();
            if (chain)
                System.out.println("Chain already equipped");
            else{
                System.out.print("Chain use: ");
            chain = sc.nextBoolean();}
            if (((target_self == false)||(target_self == true && round == true)) && (!chain)){
                if (round)
                    health[bool_to_int(target_self)]--;
                player_turn = !player_turn;
                System.out.println("Turn changes");
            }
            System.out.println("dealer health: "+health[0]);
            System.out.println("player health: "+health[1]);
        }
    }
}
