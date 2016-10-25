package olympiaad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ReadData class for Medals, to read data from the "medalidsis.txt" file.
 * Created by Rando on 22.10.2016.
 */
class Data {
    ArrayList<Integer> medals = new ArrayList<>();

    ArrayList<ArrayList<Integer>> medalsDtE = new ArrayList<>();

    int medalsAmount;

    Data() {
        digestData();
    }

    private void digestData() {
        /* Read from file */
        try {
            TextIO.readFile("medalidsis.txt");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Can't open file \"medalidsis.txt\" for reading!");
            System.out.println("Please make sure the file is present before");
            System.out.println("running the program.");
            System.exit(1);  // Terminates the program.
        }
        /* Save the medals to array and sort the array */
        this.medalsAmount = TextIO.getInt();

        while (true) {
            try {
                int second = TextIO.getInt();
                this.medals.add(second);
            } catch (IllegalArgumentException e) {
                break;
            }
        }
        Collections.sort(this.medals);
        separateDuplicates(this.medals); // creates array with duplicates in the end called "medalsDtE"

        breakToSeries(medalsDtE.get(0));
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

        this.medalsDtE.add(list); // Add the non duplicate medals to global variable medalsDtE.

        if (!temp.isEmpty()){
            separateDuplicates(temp); // If temp array has duplicates in it, repeat the process with temp array.
        }
    }
    
    private void breakToSeries(ArrayList<Integer> list) {
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();

        boolean broken = false;

        for (int x = 1; x < list.size(); x++) {
            if (list.get(x) - list.get(x - 1) > 1) {
                broken = true;
            }
            if (broken) {
                temp1.add(list.get(x));
            } else if (!broken) temp2.add(list.get(x));

        }
        System.out.println(temp2);
        System.out.println(temp1);
    }

    void printMedals() {
        this.medalsDtE.forEach(System.out::println); // Print out each item in medals on seperate line (method call).
    }
}
