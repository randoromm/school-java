package javacourse.praktikum6;

/**
 * Created by rrommot on 23.09.16.
 * Praks6, Meetodid
 */
public class Methods {
    public static void main(String[] args) {
        System.out.print("Sisesta arv: ");
        double initialNumber = TextIO.getlnDouble();
        double powerToThree = powerToThree(initialNumber);

        System.out.printf("%1.2f kuubis on: %1.2f%n", initialNumber, powerToThree);
        System.out.println(userInputBetween("Sisesta täisarv: ", 0, 6));
        headsOrTails();
        pickRandomPerson();
    }

    private static double powerToThree(double number) {
        return Math.pow(number, 3);
    }

    private static int userInputBetween(String question, int min, int max) {
        int userInput;

        while (true) {
            System.out.print(question);
            userInput = TextIO.getlnInt();
            if (userInput < max && userInput > min) break;
        }
        return userInput;
    }

    public static boolean headsOrTails() {
        int userInput = userInputBetween("Kull või kiri (0 või 1): ", -1, 2);
        int headsTails = (int)Math.round(Math.random());
        if (userInput == headsTails) {
            System.out.println("Õige!");
            return true;
        } else {
            System.out.println("No luck :(");
            return false;
        }
    }

    private static void pickRandomPerson() {
        TextIO.put("Sisesta inimeste arv: ");
        int userInput = TextIO.getlnInt();
        int randomPerson = (int) Math.round(Math.random() * (userInput - 1)) + 1;
        System.out.printf("Person number %d is the lucky motherfucker!", randomPerson);

    }
}