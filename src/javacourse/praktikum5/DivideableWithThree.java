package javacourse.praktikum5;

/**
 * Created by rando on 18.09.16.
 * from 30 to 0 divideable with 3..
 * No comments still, are they necessary tho?
 */
public class DivideableWithThree {
    public static void main(String[] args) {
        int N;
        for (N = 30; N >= 0; N = N - 3) {
            TextIO.put(N + " ");
        }
    }
}
