package javacourse.praktikum5;

/**
 * Created by rando on 18.09.16.
 * ayy lmao
 */
public class InterestingTable {
    public static void main(String[] args) {
        int tableSize = 12;
        int k;
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                k = (i + j) % tableSize;
                System.out.printf("%4d", k);
            }
            TextIO.putln();
        }
    }
}
