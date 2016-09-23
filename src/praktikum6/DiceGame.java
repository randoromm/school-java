package praktikum6;

/**
 * Created by rando on 23.09.16.
 * Jajah
 */
public class DiceGame {
    public static void main(String[] args) {
        int userDice1 = rollXManyDices.rollDices("Your first dice rolled: %d%n", 1);
        int userDice2 = rollXManyDices.rollDices("Your second dice rolled: %d%n", 1);
        int compDice1 = rollXManyDices.rollDices("My first dice rolled: %d%n", 1);
        int compDice2 = rollXManyDices.rollDices("My second dice rolled: %d%n", 1);
        int userSum = userDice1 + userDice2;
        int compSum = compDice1 + compDice2;
        System.out.println();
        if (userSum < compSum) {
            System.out.println("I win >:)!");
        } else if (userSum == compSum) {
            System.out.println("Seems like there is no winner :O!");
        } else {
            System.out.println("Luck is on your side :'(!");
        }
    }
}
