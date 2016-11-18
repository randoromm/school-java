package praktikum14;

import java.io.File;
import java.util.ArrayList;

import static praktikum14.AlphabetOrder.readFile;

/**
 * Finds the arithmetic average of numbers in file.
 * Created by rrommot on 18.11.16.
 */
public class ArithmeticAvg {
    public static void main(String[] args) {
        String path = ArithmeticAvg.class.getResource(".").getPath();
        File file = new File(path + "numbrid.txt");
        ArrayList<Double> numbers = parseNumbers(readFile(file));
        System.out.println(averageOfArrayList(numbers));

    }

    private static ArrayList<Double> parseNumbers(ArrayList<String> rows) {
        ArrayList<Double> result = new ArrayList<>();
        double num;

        for (String s : rows) {
            num = Double.parseDouble(s);
            result.add(num);
        }

        return result;
    }

    private static double averageOfArrayList(ArrayList<Double> numbers) {
        double result = 0;
        for (Double d : numbers) {
            result += d;
        }
        result /= numbers.size();
        return result;
    }
}
