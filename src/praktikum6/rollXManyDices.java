package praktikum6;

/**
 * Created by rando on 24.09.16.
 * Pretty straight forward and ez pz
 */
public class rollXManyDices {
    public static void main(String[] args) {
        TextIO.putln("The sum of the rolls is: " + rollDices("Dice rolled: %d%n", 5));
    }

    public static int rollDices(String statement, int numberOfRolls) {
        int diceRes; // The result of dice roll
        int[] diceList = new int[6]; // Array that contains all values of a dice (duuh)
        for (int i = 0; i < diceList.length; i++) { // Loops through diceList
            diceList[i] = i + 1; // Adds correct values to each index
        }
        int sumOfRolls = 0; // Holds the sum of the rolls after each roll ;)
        for (int x = 1; x < numberOfRolls + 1; x++) {
            diceRes = diceList[(int) Math.round(Math.random() * 5)];
            sumOfRolls += diceRes; // adds the dice roll result to the sum
            System.out.printf(statement, diceRes);
        }
        return sumOfRolls;
    }
}
