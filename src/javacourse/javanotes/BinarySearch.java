package javacourse.javanotes;

/**
 * Recursive BinarySearch
 * Created by rando on 2.11.16.
 */
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {0, 10, 20, 30, 40, 50, 60, 70, 80, 90}, 0, 9, 20));
    }

    /**
     * Search in the array A in positions numbered loIndex to hiIndex,
     * inclusive, for the specified value.   If the value is found, return
     * the index in the array where it occurs. If the value is not found,
     * return -1.  Precondition:  The array must be sorted into increasing
     * order.
     */
    private static int binarySearch(int[] A, int loIndex, int hiIndex, int value) {

        if (loIndex > hiIndex) {
            // The starting position comes after the final index,
            // so there are actually no elements in the specified
            // range.  The value does not occur in this empty list!
            return -1;
        }

        else {
            // Look at the middle position in the list.  If the
            // value occurs at that position, return that position.
            // Otherwise, search recursively in either the first
            // half or the second half of the list.
            int middle = (loIndex + hiIndex) / 2;
            if (value == A[middle])
                return middle;
            else if (value < A[middle])
                return binarySearch(A, loIndex, middle - 1, value);
            else   // value must be > A[middle]
                return binarySearch(A, middle + 1, hiIndex, value);
        }

    } // end binarySearch()
}