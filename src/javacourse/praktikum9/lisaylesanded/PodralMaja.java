package javacourse.praktikum9.lisaylesanded;

import java.util.Scanner;

/**
 * :)
 * Created by rando on 14.10.16.
 */
public class PodralMaja {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String song = "Põdral maja metsa sees, \n" +
                "Väiksest aknast välja vaatab. \n" +
                "Jänes jookseb kõigest väest, \n" +
                "lävel seisma jääb. \n" +
                "\n" +
                "Kop-kop lahti tee! \n" +
                "Metsas kuri jahimees! \n" +
                "Jänes tuppa tule sa, \n" +
                "anna käppa ka! ";

        System.out.println("Enter a character (letter) to replace vowels in the song with: ");
        char letter = input.nextLine().charAt(0);
        System.out.println(replaceVowels(song, letter));
        int a = -0xa;
        System.out.println(a);
    }

    private static boolean isVowel(char c) {
        return "AEIOUÕÄÖÜaeiouõäöü".indexOf(c) != -1;
    }

    private static String replaceVowels(String text, char letter) {
        String newText = "";
        for (int i = 0; i < text.length(); i++) {
            if (isVowel(text.charAt(i))) {
                newText += letter;
            } else {
                newText += text.charAt(i);
            }
        }
        return newText;
    }
}
