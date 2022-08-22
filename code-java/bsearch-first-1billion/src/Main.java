
import java.io.*;
import java.util.*;
// Add any extra import statements you may need here

/**
 * 1 Billion Users
 * We have N different apps with different user growth rates.
 * At a given time t, measured in days, the number of users using an app is g^t (for simplicity we'll allow fractional users),
 * where g is the growth rate for that app.
 * These apps will all be launched at the same time and no user ever uses more
 * than one of the apps.
 * We want to know how many total users there are when you add together the number of users from each app.
 * After how many full days will we have 1 billion total users across the N apps?
 * <p>
 * Signature
 * int getBillionUsersDay(float[] growthRates)
 * <p>
 * Input
 * 1.0 < growthRate < 2.0 for all growth rates
 * 1 <= N <= 1,000
 * <p>
 * Output
 * Return the number of full days it will take before we have a total of 1 billion users across all N apps.
 * <p>
 * Example 1
 * growthRates = [1.5]
 * output = 52
 * <p>
 * Example 2
 * growthRates = [1.1, 1.2, 1.3]
 * output = 79
 * <p>
 * Example 3
 * growthRates = [1.01, 1.02]
 * output = 1047
 */
public class Main {

    // Add any helper functions you may need here
    float getNumberOfUsers(float[] growthRates, int t) {
        float sumOfUsers = 0;
        for (int i = 0; i < growthRates.length; i++)
            sumOfUsers += Math.pow(growthRates[i], t);
        return sumOfUsers;
    }

    //
    int findNumberOfDaysByBinarySearch(float[] growthRates, int left, int right, double target) {
        int middle = left + (right - left) / 2;
        float sumMiddle = getNumberOfUsers(growthRates, middle);
        if (sumMiddle < target) {
            if ((right - left) > 1)
                return findNumberOfDaysByBinarySearch(growthRates, middle, right, target);
            else
                return right;
        } else if (sumMiddle > target) {
            if ((right - left) > 1)
                return findNumberOfDaysByBinarySearch(growthRates, left, middle, target);
            else
                return middle;
        } else
            return middle;
    }

    // 1) find t>1,000,000,000 by power of 2 jumps
    // 2) do binary search between t/2 and t days
    int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        float sumOfUsers = growthRates.length;
        int t = 1;
        // 1) find t>1,000,000,000 by power of 2 jumps
        while (sumOfUsers < 1000000000) {
            t *= 2;
            sumOfUsers = getNumberOfUsers(growthRates, t);
        }
        // 2) do binary search between t/2 and t days
        return findNumberOfDaysByBinarySearch(growthRates, t / 2, t, 1000000000);
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        float[] test_1 = {1.1f, 1.2f, 1.3f};
        int expected_1 = 79;
        int output_1 = getBillionUsersDay(test_1);
        check(expected_1, output_1);

        float[] test_2 = {1.01f, 1.02f};
        int expected_2 = 1047;
        int output_2 = getBillionUsersDay(test_2);
        check(expected_2, output_2);


        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}