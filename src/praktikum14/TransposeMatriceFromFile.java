package praktikum14;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static praktikum13.Matrices.printMatrice;
import static praktikum13.Matrices.transpose;
import static praktikum14.AlphabetOrder.readFile;

/**
 * This class reads a matrix from file and transposes it.
 * Created by rrommot on 18.11.16.
 */
public class TransposeMatriceFromFile {
    public static void main(String[] args) {
        String path = TransposeMatriceFromFile.class.getResource(".").getPath();
        File file = new File(path + "matrix.txt");
        ArrayList<String> rows = readFile(file);

        printMatrice(transpose(parseMatrice(rows)));

    }

    private static int[][] parseMatrice(ArrayList<String> lines) {
        int[][] result = new int[lines.size()][parseLine(lines.get(0)).length];

        for(int i = 0; i < lines.size(); i++) {
            result[i] = parseLine(lines.get(i));
        }

        return result;
    }

    private static int[] parseLine(String line) {
        String[] strings = line.split(" ");
        int[] numbers = new int[strings.length];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = Integer.parseInt(strings[i]);
        }
        return numbers;
    }
}
