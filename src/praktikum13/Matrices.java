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

        int[][] morpheus = {
                {1, 2},
                {3, 4},
                {5, 6},
        };

        printOneDimArray(neo[1]);

        printMatrice(neo);

        printOneDimArray(sumOfRows(neo));

        System.out.println(sumOfSecondaryDiagonal(neo));

        printOneDimArray(maxOfRows(neo));

        System.out.println(minimumOfMatrice(neo));

        printMatrice(modulusMatrice(3, 5));

        printMatrice(transpose(morpheus));

        System.out.println(sumOfPrimaryDiagonal(neo));
    }

    private static int[][] transpose(int[][] matrice) {
        int[][] result = new int[matrice[0].length][matrice.length];
        for (int y = 0; y < matrice.length; y++) {
            for (int x = 0; x < matrice[y].length; x++) {
                result[x][y] = matrice[y][x];
            }
        }
        return result;
    }

    private static int[][] modulusMatrice(int rows, int columns) {
        int[][] result = new int[rows][columns];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                result[y][x] = (y + x) % 2;
            }
        }
        return result;
    }

    private static int minimumOfMatrice(int[][] matrice) {
        int result = matrice[0][0];
        for (int[] array : matrice) {
            for (int element : array) {
                if (element < result) result = element;
            }
        }
        return result;
    }

    private static int[] maxOfRows(int[][] matrice) {
        int[] result = new int[matrice.length];

        for(int i = 0; i < matrice.length; i++) {
            int max = matrice[i][0];
            for (int element : matrice[i]) {
                if (element > max) max = element;
            }
            result[i] = max;
        }

        return result;
    }

    /**
     * Was not a problem in class, but i think it's good to know.
     * @param matrice 2 Dimensional array (Matrice).
     * @return Sum of the primary diagonal elements (left top to right bottom corner)
     */
    private static int sumOfPrimaryDiagonal(int[][] matrice) {
        int result = 0;
        for(int i = 0; i < matrice.length; i++) {
            result += matrice[i][i];
        }
        return result;
    }

    private static int sumOfSecondaryDiagonal(int[][] matrice) {
        int result = 0;
        int i = matrice[0].length - 1;
        for (int[] array : matrice) {
            result += array[i];
            i--;
        }
        return result;
    }

    private static int[] sumOfRows(int[][] matrice) {
        int[] result = new int[matrice.length];
        for (int k = 0; k < matrice.length; k++) {
            int sum = 0;
            for (int i : matrice[k]) {
                sum += i;
            }
            result[k] = sum;
        }
        return result;
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
