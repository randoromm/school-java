package javacourse.praktikum5;

/**
 * Created by rando on 18.09.16.
 * ayy lmao
 */
public class TableWithBorders {
    public static void main(String[] args) {
        System.out.print("Enter table size: ");
        int tableSize = TextIO.getlnInt();

        topAndBottomBorder(tableSize);
        for (int i = 0; i < tableSize; i++) {
            TextIO.put("|");
            for (int j = 0; j < tableSize; j++) {
                if (i == j || i == tableSize - j - 1) TextIO.put(" X");
                else TextIO.put(" 0");
            }
            TextIO.putln(" |");
        }
        topAndBottomBorder(tableSize);
    }

    private static void topAndBottomBorder(int sizeOfTable) {
        for (int i = 0; i < sizeOfTable + 1; i++)
            TextIO.put("..");
        TextIO.putln(".");
    }

}
