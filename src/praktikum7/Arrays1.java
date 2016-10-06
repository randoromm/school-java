package praktikum7;

import java.util.Random;
import java.util.Scanner;

/**
 * Nonii nonii
 * Created by rando on 5.10.16.
 */
public class Arrays1 {
    public static void main(String[] args) {
        Random rndm = new Random();
        Scanner input = new Scanner(System.in);
        Scanner nameInput = new Scanner(System.in);

        System.out.println("Enter number of people: ");
        int numOfPeople = input.nextInt();
        String[] listOfPeople = new String[numOfPeople];

        for (int i = 0; i < numOfPeople; i++) {
            System.out.printf("Enter the name of %d. person:%n", i+1);
            String name = nameInput.nextLine();
            listOfPeople[i] = name;
        }
        System.out.printf("The lucky one is: %s%n", listOfPeople[rndm.nextInt(numOfPeople)]);
    }
}
