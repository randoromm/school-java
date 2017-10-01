package praktikum7;

import java.util.Scanner;

import static praktikum6.Methods.headsOrTails;

/**
 * Heads or tails with bets
 * Created by rando on 5.10.16.
 */
public class HeadsOrTailsVol2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean victory;
        int userBalance = 100;
        int userBet = 0;

        while (userBalance > 0) {
            System.out.printf("Your balance is %d euros%n", userBalance);
            while (userBet > 25 || userBet < 1) {
                System.out.println("How much do you want to bet (1 - 25) (int pls)?: ");
                userBet = input.nextInt();
            }
            userBalance -= userBet;
            System.out.printf("You bet %d bucks, your balance is now %d euros%n", userBet, userBalance);
            victory = headsOrTails();
            if (victory) userBalance += userBet * 2;
            userBet = 0; // To re-trigger the loop for a bet
        }
        System.out.println("You are out of money :( !");
    }
}
