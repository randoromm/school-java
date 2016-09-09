package praktikum4;

/**
 * Created by rrommot on 9.09.16.
 */
public class ArtificialIntelligence {
    public static void main(String[] args) {
        int fAge = testInput("Enter first age: ");
        int sAge = testInput("Enter second age: ");
        int difAge = Math.abs(fAge - sAge); // Calculates the difference between ages

        if (difAge > 10) {
            System.out.println("Pedo oled v?");
        } else if (difAge > 5 && difAge <= 10) {
            System.out.println("Toorikud lähevad peale või?");
        } else {
            System.out.println("Lase minna!");
        }
    }

    private static int testInput(String question) {
        System.out.println(question);
        int age = TextIO.getlnInt();
        if (age < 0) {
            System.out.println("You didn't enter a valid age (Positive).");
            System.exit(0);
        }
        return age;
    }
}
