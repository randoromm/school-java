package praktikum4;

/**
 * Created by rrommot on 8.09.16.
 * Isn't optimized, finish at home
 */
public class CumLaudeDetector {
    public static void main(String[] args) {
        System.out.println("Sisesta oma kaalutud keskhinne: ");
        double averageMark = TextIO.getlnDouble();
        System.out.println("Sisesta oma kaalutud keskhinne: ");
        double finalPaperMark = TextIO.getlnInt();


        if ((averageMark >= 0 && averageMark <= 5) && (finalPaperMark >= 0 && finalPaperMark <= 5)) {

            if ((averageMark > 4.5 && averageMark <= 5) && finalPaperMark == 5) { // if mark is proper
                System.out.println("Jah saad cum laude diplomile!");
            } else {
                System.out.println("Ei saa cum laudet :(");
                System.out.println("int finalPaperMark is " + finalPaperMark);  // Double -> int ?
            }
        } else {
            System.out.println("Hinne peab olema 0 ja 5 vahel"); // If 0 < mark > 5
        }
    }
}
