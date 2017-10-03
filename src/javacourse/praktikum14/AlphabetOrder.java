package javacourse.praktikum14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Print rows of a file in alphabetical order.
 * Created by rrommot on 18.11.16.
 */
public class AlphabetOrder {
    public static void main(String[] args) {
        String path = AlphabetOrder.class.getResource(".").getPath();
        File file = new File(path + "kala.txt");
        for (String s : sortAlphabetically(readFile(file))) {
            System.out.println(s);
        }

    }

    public static ArrayList<String> readFile(File file) {
        ArrayList<String> result = new ArrayList<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));

            String row;

            while ((row = input.readLine()) != null) {
                result.add(row);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Faili ei leitud: \n" + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Error: \n" + e.getStackTrace());
        }
        return result;
    }

    private static ArrayList<String> sortAlphabetically(ArrayList<String> rows) {
        Collections.sort(rows);
        return rows;
    }
}
