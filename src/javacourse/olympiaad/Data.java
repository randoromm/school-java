package javacourse.olympiaad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ReadData class for Medals, to read data from the chosen file.
 * Created by Rando on 22.10.2016.
 */
class Data {
    private ArrayList<Integer> medals = new ArrayList<>();

    private ArrayList<Integer> medalsDtE = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    /**
     * Reads from chosen file and digests the data, creating an object for the data.
     * @param filePath path of the chosen text file to digest data from.
     */
    Data(String filePath) {
        /* Read from file */
        try {
            TextIO.readFile(filePath);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Can't open file \"medalidsis.txt\" for reading!");
            System.out.println("Please make sure the file is present before");
            System.out.println("running the program.");
            System.exit(1);  // Terminates the program.
        }
        /* Save the medals to array and sort the array */
        TextIO.getInt(); // Discard amount of medals on the first line of file
        while (!TextIO.eof()) { // eof - end of file, still throws exception because using getInt not getLn.
            try {
                int second = TextIO.getInt();
                this.medals.add(second);
            } catch (IllegalArgumentException e) {
                break;
            }
        }
        Collections.sort(this.medals);
        separateDuplicates(this.medals); // creates array with duplicates in the end called "medalsDtE"
        breakToSeries(medalsDtE);
    }


    private void separateDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> temp = new ArrayList<>();

        for (int x = 1; x < list.size(); x++) {
            if (list.get(x).equals(list.get(x - 1))) {
                temp.add(list.get(x)); // Add duplicates to temp array.
            }
        }

        Set<Integer> set1 = new LinkedHashSet<>(list); // To remove duplicates from initial array.
        list = new ArrayList<>(set1);

        this.medalsDtE.addAll(list); // Add the non duplicate medals to global variable medalsDtE.

        if (!temp.isEmpty()){
            separateDuplicates(temp); // If temp array has duplicates in it, repeat the process with temp array.
        }
    }
    
    private void breakToSeries(ArrayList<Integer> list) {
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();

        boolean broken = false;

        temp2.add(list.get(0));
        for (int x = 1; x < list.size(); x++) {
            if (list.get(x) - list.get(x - 1) != 1) {
                broken = true;
            }
            if (broken) {
                temp1.add(list.get(x));
            } else temp2.add(list.get(x));
        }

        result.add(temp2);
        if (!temp1.isEmpty()) breakToSeries(temp1);
    }

    void printResult() {
        System.out.println(this.result.size());

        this.result.forEach(list -> {
            System.out.print(list.size());
            list.forEach(integer -> System.out.print(" " + integer));
            System.out.println();
        });
    }
}
