package praktikum7;

import java.util.Random;
import java.util.Scanner;

/**
 * Esimene praksi ulesanne
 * Created by rando on 5.10.16.
 */
public class GuessingGame {
    public static void main(String[] args) {
        guessNumber("Guess what number the computer chose from 1 to 100 inclusive (int)!");
    }

    private static void guessNumber(String initQuestion) {
        int machineNum, userInput;
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        machineNum = random.nextInt(99) + 1;
        System.out.println(initQuestion);
        while (true) {
            System.out.print("Your guess: ");
            userInput = input.nextInt();
            System.out.println();
            if (userInput == machineNum) {
                System.out.println("You are correct!");
                break;
            }
            if (userInput > machineNum) {
                System.out.println("Your number is larger, guess again!");
            }
            if (userInput < machineNum) {
                System.out.println("Your number is smaller, guess again!");
            }
        }
    }
}
