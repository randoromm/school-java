package praktikum10;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Diagram
 * Created by rrommot on 21.10.16.
 */
public class Diagram {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> userInputs = new ArrayList<>();

        System.out.println("Enter numbers, enter 0 if you want to stop");
        while (true) {
            System.out.println("Enter your number: ");
            int uInp = input.nextInt();
            if (uInp > 0) {
                userInputs.add(uInp);
            }
            else if (uInp < 0) {
                System.out.println("Enter a positive number!");
            }
            else break;
        }

        for (Integer ele : userInputs) {
            String x = "";
            for (int i = 0; i < ele; i++) {
                x += "x";
            }
            System.out.format("%2d %s%n", ele, x);
        }
    }
}
