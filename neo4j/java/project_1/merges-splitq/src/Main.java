
import java.io.*;
import java.util.*;
// Add any extra import statements you may need here

/**
 * Balanced Split
 * Given an array of integers (which may include repeated integers), determine if there's a way to split the array into two subsequences A and B such that the sum of the integers in both arrays is the same, and all of the integers in A are strictly smaller than all of the integers in B.
 * Note: Strictly smaller denotes that every integer in A must be less than,
 * and not equal to, every integer in B.
 * <p>
 * Signature
 * bool balancedSplitExists(int[] arr)
 * Input
 * All integers in array are in the range [0, 1,000,000,000].
 * Output
 * Return true if such a split is possible, and false otherwise.
 * <p>
 * Example 1
 * arr = [1, 5, 7, 1]
 * output = true
 * We can split the array into A = [1, 1, 5] and B = [7].
 * <p>
 * Example 2
 * arr = [12, 7, 6, 7, 6]
 * output = false
 * We can't split the array into A = [6, 6, 7] and B = [7, 12] since
 * this doesn't satisfy the requirement that all integers in A are smaller
 * than all integers in B.
 */

public class Main {

    // Add any helper functions you may need here


    boolean balancedSplitExists(int[] arr) {
        // Write your code here
        //1) sort
        //2) sum arrays O(n)
        //3) check if A and B exist
        Arrays.sort(arr);
        long[] sumA = new long[arr.length];
        long[] sumB = new long[arr.length];
        sumA[0] = arr[0];
        sumB[arr.length - 1] = arr[arr.length - 1];
        int i;
        for (i = 1; i < arr.length; i++) {
            sumA[i] = arr[i] + sumA[i - 1];
            sumB[arr.length - 1 - i] = arr[arr.length - 1 - i] + sumB[arr.length - i];
        }
        i = 0;
        for (; i < arr.length - 1; i++)
            if (sumA[i] == sumB[i + 1]) return (arr[i] < arr[i + 1]);
        return false;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        int arr_1[] = {2, 1, 2, 5};
        boolean expected_1 = true;
        boolean output_1 = balancedSplitExists(arr_1);
        check(expected_1, output_1);

        int arr_2[] = {3, 6, 3, 4, 4};
        boolean expected_2 = false;
        boolean output_2 = balancedSplitExists(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}
