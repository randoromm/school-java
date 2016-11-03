package kontrolltoo2;

import java.util.ArrayList;
import java.util.Collections;

public class Answer {

    public static void main (String[] args) {
        System.out.println (score (new int[]{4, 1, 2, 3, 0})); // 9
        // Your tests here
    }

    private static int score (int[] points) {
        ArrayList<Integer> temp = new ArrayList<>();
        int result = 0;

        for (int i : points) {
            temp.add(i);
        }
        Collections.sort(temp);
        temp.remove(0);
        temp.remove(0);

        for (Integer i : temp) {
            result += i;
        }
        return result;
    }

}