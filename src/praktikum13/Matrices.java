package praktikum13;

/**
 * Blbalba
 * Created by Rando on 16.11.2016.
 */
public class Matrices {
    public static void main(String[] args) {
        int[][] neo = {
                {1, 1, 1, 1, 1},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7},
                {4, 5, 6, 7, 8},
                {5, 6, 7, 8, 9},
        };

        printOneDimArray(neo[1]);
        System.out.println();
        printMatrice(neo);
        System.out.println();
        sumOfRows(neo);
    }

    private static void sumOfRows(int[][] neo) {
        // TODO
    }

    private static void printOneDimArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printMatrice(int[][] matrice) {
        for (int[] i : matrice) {
            printOneDimArray(i);
        }
    }
}
