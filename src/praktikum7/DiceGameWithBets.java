package praktikum7;

import java.util.Scanner;
import static praktikum6.rollXManyDices.rollDices;

/**
 * Heads or tails with bets
 * Created by rando on 5.10.16.
 */
public class DiceGameWithBets {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rollResult;
        int userGuess = 0;
        int userBalance = 100;
        int userBet = 0;

        while (userBalance > 0) {
            System.out.printf("Your balance is %d euros%n", userBalance);
            while (userBet > 25 || userBet < 1) {
                System.out.println("How much jevros do you want to bet (1 - 25) (int pls)?: ");
                userBet = input.nextInt();
            }
            userBalance -= userBet;
            System.out.printf("You bet %d bucks, your balance is now %d euros%n", userBet, userBalance);
            while (userGuess < 1 || userGuess > 6) {
                System.out.println("What will the wizard roll (hint: not dank kush)?: ");
                userGuess = input.nextInt();
            }
            rollResult = rollDices("Wizard rolled: %d%n", 1);
            if (rollResult == userGuess) {
                System.out.println("You are correct!");
                userBalance += userBet * 6;
            }
            else System.out.println("You are wrong!");
            userBet = 0; // To re-trigger the loop for a bet
            userGuess = 0;

        }
        System.out.println("You are out of money :( !");
    }
}
