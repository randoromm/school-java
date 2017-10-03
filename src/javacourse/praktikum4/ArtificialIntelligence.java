package javacourse.praktikum4;

/**
 * Created by rrommot on 9.09.16.
 * Finished. Could still document and comment.
 */
public class ArtificialIntelligence {
    public static void main(String[] args) {
        int fAge = testInput("Enter first age: ");
        int sAge = testInput("Enter second age: ");
        int difAge = Math.abs(fAge - sAge);  // Calculates the difference between ages

        if (difAge > 10) {
            System.out.println("Midagi veel krõbedamat.");
        } else if (difAge > 5 && difAge <= 10) {
            System.out.println("Midagi krõbedamat.");
        } else {
            System.out.println("Sobib!");
        }
    }

    private static int testInput(String question) {
        System.out.println(question);
        int age = TextIO.getlnInt();
        if (age < 0) {
            System.out.println("Vanus on positiivne arv, nõdrameelne.");
            System.exit(0);
        }
        return age;
    }
}
