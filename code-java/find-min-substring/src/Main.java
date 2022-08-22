
import java.io.*;
import java.util.*;
// Add any extra import statements you may need here

/**
 * Substrings
 * You are given two strings s and t. You can select any substring of string s
 * and rearrange the characters of the selected substring.
 * Determine the minimum length of the substring of s such that
 * string t is a substring of the selected substring.
 * <p>
 * Signature
 * int minLengthSubstring(String s, String t)
 * <p>
 * Input
 * s and t are non-empty strings that contain less than 1,000,000 characters each
 * <p>
 * Output
 * Return the minimum length of the substring of s. If it is not possible, return -1
 * <p>
 * Example
 * s = "dcbefebce"
 * t = "fd"
 * output = 5
 * Explanation:
 * Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on.
 * String t is a substring of "cfdeb". Thus, the minimum length required is 5.
 */
public class Main {

    // Add any helper functions you may need here


    void calcFrequencies(String input, int[] output) {
        //Arrays.fill(output,0);
        if (input == null || input.length() < 1)
            return;
        //
        int i;
        for (i = 0; i < input.length(); i++)
            output[(int) (input.charAt(i) - 'a')]++;
    }

    boolean contains(int[] freqSij, int[] freqT) {
        boolean response = false;
        int i = 0;
        while (i < freqT.length && freqSij[i] >= freqT[i])
            i++;
        return (i == freqT.length);
    }

    int minLengthSubstring(String s, String t) {
        // Write your code here
        // 1) build frequency vector for t
        // for each substring of s:
        //    calculate frequency vector of substring
        //    check if frequency vector(substring) >= freqency_vector(t), then
        //         track min length
        int[] freqSij = new int[26];
        int[] freqT = new int[26];

        Arrays.fill(freqT, 0);
        calcFrequencies(t, freqT);

        int i, j;
        boolean found = false;
        int minLength = Integer.MAX_VALUE;

        for (i = 0; i < (s.length() - t.length()); i++)
            for (j = (i + t.length()); j < s.length(); j++) {
                String subStr = s.substring(i, j);
                Arrays.fill(freqSij, 0);
                calcFrequencies(subStr, freqSij);
                if (contains(freqSij, freqT)) {
                    if ((j - i) < minLength)
                        minLength = (j - i);
                    found = true;
                }
            }
        return (found ? minLength : -1);
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

    public void run() throws IOException {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        int output_1 = minLengthSubstring(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
