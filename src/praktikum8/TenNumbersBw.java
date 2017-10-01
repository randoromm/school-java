package praktikum8;

import java.util.Scanner;

/**
 * blbabla
 * Created by rando on 10.10.16.
 */
public class TenNumbersBw {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        int[] numbersList = new int[10];
        for(int i = 0; i < 10; i++) {
            System.out.printf("Sisesta %d. number: ", i + 1);
            number = input.nextInt();
            numbersList[i] = number;
        }
        for (int j = 9; j >= 0; j--) {
            System.out.println(numbersList[j]);
        }

    }
}
