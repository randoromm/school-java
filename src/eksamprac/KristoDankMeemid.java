package eksamprac;

/**
 * Ayy lmao.
 * Created by rando on 8.01.17.
 */
public class KristoDankMeemid {
    public static void main (String[] args) {
        // First.
        System.out.println (allaKeskmise (new double[]{1, 3, 6, 7, 8, 3, 5, 7, 21, 3}));

        System.out.println();

        // Second.
        int[][] res = muster (9);
        for (int column = 0; column < res[0].length; column++) {
            for (int row = 0; row < res.length; row++) {
                System.out.print(res[row][column] + " ");
            }
            System.out.println();
        }

        System.out.println();

        // Fourth.
        int[] res2 = veeruSummad (new int[][] { {1,2,3}, {4,5,6} }); // {5, 7, 9}
        for (int i : res2) {
            System.out.print(i + " ");
        }
    }

    public static int allaKeskmise (double[] d) {
        // Calculate average.
        double avg = 0;
        for (double i : d) {
            avg += i;
        }
        avg /= d.length;

        // Count of strictly lower elements.
        int count = 0;
        for (double i : d) {
            if (i < avg) {
                count++;
            }
        }
        return count;
    }

    public static int[][] muster (int n) {
        int[][] result = new int[n][n];

        for (int column = 0; column < result[0].length; column++) {
            for (int row = 0; row < result.length; row++) {
                result[row][column] = Math.min(row, column);
            }
        }

        return result;
    }

    public static int[] veeruSummad(int[][] m) {
        int[] result = new int[m[0].length];

        for (int column = 0; column < m[0].length; column++) {
            for (int row = 0; row < m.length; row++) {
                result[column] += m[row][column];
            }
        }

        return result;
    }
}
