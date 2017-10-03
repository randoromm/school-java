package javacourse.praktikum9;

/**
 * jfgjdf
 * Created by rrommot on 14.10.16.
 */
public class Palindrome {
    public static void main (String[] args) {
        System.out.println("Sisesta s6na: ");
        String word1 = TextIO.getln();
        String word2 = "";
        boolean palindrome = false;

        for(int i = word1.length() - 1; i >= 0; i--) {
            word2 += word1.charAt(i);
        }

        if (word1.equals(word2)) {
            palindrome = true;
        }

        if (palindrome) {
            System.out.printf("S6na %s on palindroom!%n", word1);
        }
        else {
            System.out.printf("S6na %s ei ole palindroom: %n", word1);
        }
    }
}
