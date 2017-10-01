package praktikum7;

import java.util.Scanner;

/**
 * Turn string around..
 * Created by rando on 5.10.16.
 */
public class BackwardsString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a word(can also be a sentence): ");
        String inputString = input.nextLine();
        String result = turnAround(inputString);
        System.out.println(result);
        System.out.println();
        System.out.println();
        System.out.println(turnAround("kuulilennuteetunneliluuk"));
    }

    private static String turnAround(String inputString) {
        int len = inputString.length() - 1;
        String newString = "";
        for (int i = len; i >= 0; i--) {
            newString += inputString.charAt(i);
        }
        return newString;
    }
}
