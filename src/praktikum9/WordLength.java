package praktikum9;

/**
 * lhgjlg
 * Created by rrommot on 14.10.16.
 */
public class WordLength {
    public static void main(String[] args) {
        int amntWords = 2;
        int[] length = new int[amntWords];
        String[] words = new String[amntWords];

        for(int i = 0; i < amntWords; i++) {
            System.out.printf("Enter %d. word: %n", i + 1);
            words[i] = TextIO.getln();
        }

        for(int j = 0; j < amntWords; j++) {
            length[j] = words[j].length();
        }

        for(int k = 0; k < amntWords; k++) {
            System.out.printf("%2d %s%n", length[k], words[k]);
        }
    }
}
