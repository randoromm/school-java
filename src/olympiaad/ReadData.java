package olympiaad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ReadData class for Medals, to read data from the "medalidsis.txt" file.
 * Created by Rando on 22.10.2016.
 */
public class ReadData {
    public ArrayList<Integer> medals = new ArrayList<>();

    public ArrayList<Integer> test = new ArrayList<>();

    public int medalsAmount;

    public ReadData () {
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
        this.medals = duplicatesToEnd(this.medals);
    }

    private ArrayList<Integer> duplicatesToEnd(ArrayList<Integer> list) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> result = list;
        temp.clear();
        int lastX = 0;
        for (int x = 1; x < medalsAmount; x++) {
            try {
                if (list.get(x).equals(list.get(lastX))) {
                    temp.add(list.get(x));
                }
                lastX = x;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

        // Removing duplicates
        Set<Integer> set1 = new LinkedHashSet<>(result);
        result = new ArrayList<>(set1);

        this.test.addAll(result);

        Set<Integer> set2 = new LinkedHashSet<>(temp);

        for (Integer i : set2) {
            this.test.add(i);
        }
        if (!temp.isEmpty()) duplicatesToEnd(temp);
        return result;
    }

    void printMedals() {
        for (Integer i : this.test) {
            System.out.println(i);
        }
    }

}
