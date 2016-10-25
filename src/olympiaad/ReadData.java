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

    public ArrayList<Integer> medalsDtE = new ArrayList<>();

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
        duplicatesToEnd(this.medals); // creates array with duplicates in the end called "medalsDtE"
        this.medals = this.medalsDtE;
    }

    private void duplicatesToEnd(ArrayList<Integer> list) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> result = list;
        temp.clear();
        int lastX = 0;
        for (int x = 1; x < result.size(); x++) {
            try {
                if (result.get(x).equals(result.get(lastX))) {
                    // 1, 2, 3, 45, 46, 46, 46, 46, 47, 48, 48  -> 46 46 46 48 48
                        temp.add(result.get(x));
                }
                lastX = x;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

        // Removing duplicates
        Set<Integer> set1 = new LinkedHashSet<>(result);
        result = new ArrayList<>(set1);

        this.medalsDtE.addAll(result);

        if (!temp.isEmpty()){
            duplicatesToEnd(temp);
            temp.clear();
        }
    }

    void printMedals() {
        for (Integer i : this.medals) {
            System.out.println(i);
        }
    }

}
