package praktikum9;

/**
 * jfgjdf
 * Created by rrommot on 14.10.16.
 */
public class PalindromeEfficient {
    public static void main (String[] args) {
        System.out.println("Sisesta s6na: ");
        String word1 = TextIO.getln();
        boolean palindrome = true;

        for (int i = 0; i < word1.length() / 2; i++) {
            if (word1.charAt(i) != word1.charAt(word1.length() - 1 - i)) {
                palindrome = false;
                break;
            }
        }

        System.out.println(palindrome);
    }
}
