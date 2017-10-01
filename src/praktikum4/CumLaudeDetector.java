package praktikum4;

/**
 * Created by rrommot on 8.09.16.
 * Could still use a better
 * final mark optimization and
 * documentation.
 */
public class CumLaudeDetector {
    public static void main(String[] args) {
        double averageMark = markTest("Sisesta oma kaalutud keskhinne: ");
        /*
         * Lõputöö hinnet küsides, võiks sisestada saada aint täisarve
         * (mitte floorida neid)
         */
        int finalPaperMark = (int) markTest("Sisesta oma lõputöö hinne: "); // find better solution?

        if (averageMark > 4.5 && finalPaperMark == 5) { // if mark is proper
            System.out.println("Jah saad cum laude diplomile!");
        } else {
            System.out.println("Ei saa cum laudet :(");
        }

    } // end of main method
    private static double markTest(String inputReq) {
        System.out.println(inputReq);
        double mark = TextIO.getlnDouble();

        while (mark < 0 || mark > 5) {
            System.out.println("Hinne peab olema 0 ja 5 vahel!");
            System.out.println(inputReq);
            mark = TextIO.getlnDouble();
        }
        return mark;
    } // end of markTest
} // end of class
