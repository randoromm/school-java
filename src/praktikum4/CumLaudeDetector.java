package praktikum4;

/**
 * Created by rrommot on 8.09.16.
 */
public class CumLaudeDetector {
    public static void main (String[] args) {
        System.out.println("Sisesta oma kaalutud keskhinne: ");
        double averageMark = TextIO.getlnDouble();
        System.out.println("Sisesta oma lõputöö hinne: ");
        int finalPaperMark = TextIO.getlnInt();

        if ((averageMark > 4.5 && averageMark <= 5) && finalPaperMark == 5) {
            System.out.println("Jah saad cum laude diplomile!");
        }else if ((averageMark <= 4.5 && averageMark >= 0) && (finalPaperMark > 0 && finalPaperMark <= 5)){
            System.out.println("Ei saa cum laudet :(");
        }else{
            System.out.println("Hinne peab olema 0 ja 5 vahel");
        }
    }
}
