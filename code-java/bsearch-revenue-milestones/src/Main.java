
import java.util.*;
// Add any extra import statements you may need here


public class Main {

    // Add any helper functions you may need here

    int findIndexOfEqualsOrExceeds(int[] revenues, int target) {
        int response = -1;
        int left, right, middle;
        left = 0;
        right = revenues.length - 1;
        while (left < right) {
            middle = left + (right - left) / 2;
            if (revenues[middle] < target) {
                left = middle;
                if (((right - left) == 1) && (revenues[right] >= target))
                    return (right+1);
            } else if (revenues[middle] > target) {
                right = middle;
                if ((right - left) == 1)
                    return (middle+1);
            } else
                return (middle+1);
            System.out.println("Left="+left+" middle="+middle+" right="+right);
        }
        return response;
    }

    // milestones[] does not need to be sorted
    // to avoid O(m*n) TC, use binary search on revenue[] to obtain O(m log n) TC
    int[] getMilestoneDays(int[] revenues, int[] milestones) {
        // Write your code here
        int[] result = new int[milestones.length];
        Arrays.fill(result, -1);
        int i;
        // accumulated revenue, TC: O ( revenues.length ), linear
        for (i = 1; i < revenues.length; i++)
            revenues[i] = (revenues[i - 1] + revenues[i]);
        // do not assume anything about milestone
        for (i = 0; i < milestones.length; i++) // m
            result[i] = findIndexOfEqualsOrExceeds(revenues, milestones[i]); // n=r.length O(log n)
        // TC: O( m log n) where m = milestones.length and n = revenues.length
        // SC: O( m ) where m = milestones.length dues to result array
        printIntegerArray(result);
        return result;
    }

    int[] getMilestoneDays2(int[] revenues, int[] milestones) {
        // Write your code here
        int[] result = new int[milestones.length];
        Arrays.fill(result, -1);
        int i;
        // accumulated revenue
        for (i = 1; i < revenues.length; i++)
            revenues[i] = (revenues[i - 1] + revenues[i]);
        // no need to check if total revenue is below the first milestone
        if (milestones[0] < revenues[revenues.length - 1]) {
            int j = 0;
            i = 0;
            while (milestones.length > j) {
                while (revenues.length > i && milestones[j] > revenues[i]) i++;
                if (revenues[i] >= milestones[j]) result[j] = i + 1;
                j++;
            }
        }
        return result;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int revenues_1[] = {100, 200, 300, 400, 500};
        int milestones_1[] = {300, 800, 1000, 1400};
        int expected_1[] = {2, 4, 4, 5};
        int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
        check(expected_1, output_1);

        int revenues_2[] = {700, 800, 600, 400, 600, 700};
        int milestones_2[] = {3100, 2200, 800, 2100, 1000};
        int expected_2[] = {5, 4, 2, 3, 2};
        int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
        check(expected_2, output_2);

        // Add your own test cases here
        int revenues_2b[] = {700, 800, 600, 400, 600, 700};
        int milestones_2b[] = {3100, 2200, 800, 2100, 1000,3800};
        int expected_2b[] = {5, 4, 2, 3, 2,6};
        int[] output_2b = getMilestoneDays(revenues_2b, milestones_2b);
        check(expected_2b, output_2b);

    }

    public static void main(String[] args) {
        new Main().run();
    }
}