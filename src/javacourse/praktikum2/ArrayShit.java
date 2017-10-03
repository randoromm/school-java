package javacourse.praktikum2;

public class ArrayShit {
    public static int numberOfItems(int[] m) {
        
        return m.length;
    }

    public static void main(String[] args) {
        int [] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        System.out.println( numberOfItems(test) );
    }
}
