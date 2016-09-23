package praktikum6;

/**
 * Created by rando on 23.09.16.
 * Jajah
 */
public class DiceGame {
    public static void main(String[] args) {
        int userDice1 = rollADice();
        int userDice2 = rollADice();
        int compDice1 = rollADice();
        int compDice2 = rollADice();
        int userSum = userDice1 + userDice2;
        int compSum = compDice1 + compDice2;
        System.out.printf("You roll %d and %d!%n", userDice1, userDice2);
        System.out.printf("I roll %d and %d.%n", compDice1, compDice2);
        if (userSum < compSum) {
            System.out.println("I win >:)!");
        } else if (userSum == compSum) {
            System.out.println("Seems like there is no winner :O!");
        } else {
            System.out.println("Luck is on your side :'(!");
        }
    }

    private static int rollADice() {
        int dice1; // The result of dice roll
        int[] diceList = new int[6]; // Array that contains all values of a dice (duuh)
        for (int i = 0; i < diceList.length; i++) { // Loops through diceList
            diceList[i] = i + 1; // Adds correct values to each index
        }
        dice1 = diceList[(int)Math.round(Math.random() * 5)];
        return dice1;
    }
}
