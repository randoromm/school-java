package praktikum5;

/**
 * Created by rando on 18.09.16.
 * fucking hell
 */
public class DiagonalTable {
    public static void main(String[] args) {
        System.out.print("Enter table size: ");
        int tableSize = TextIO.getlnInt();


        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                if (i == j) {
                    TextIO.put("1 ");
                } else {
                    TextIO.put("0 ");
                }
            }
            TextIO.putln();
        }
    }
}
