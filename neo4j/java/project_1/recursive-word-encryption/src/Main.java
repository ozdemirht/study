
import java.io.*;
import java.util.*;
// Add any extra import statements you may need here

/**
 * Encrypted Words
 * You've devised a simple encryption method for alphabetic strings that shuffles the characters in such a way that the resulting string is hard to quickly read, but is easy to convert back into the original string.
 * When you encrypt a string S, you start with an initially-empty resulting string R and append characters to it as follows:
 * Append the middle character of S (if S has even length, then we define the middle character as the left-most of the two central characters)
 * Append the encrypted version of the substring of S that's to the left of the middle character (if non-empty)
 * Append the encrypted version of the substring of S that's to the right of the middle character (if non-empty)
 * For example, to encrypt the string "abc", we first take "b", and
 * then append the encrypted version of "a" (which is just "a") and the encrypted version of "c" (which is just "c") to get "bac".
 * If we encrypt "abcxcba" we'll get "xbacbca". That is, we take "x" and
 * then append the encrypted version "abc" and then append the encrypted version of "cba".
 * <p>
 * Input
 * S contains only lower-case alphabetic characters
 * 1 <= |S| <= 10,000
 * Output
 * Return string R, the encrypted version of S.
 * <p>
 * Example 1
 * S = "abc"
 * R = "bac"
 * <p>
 * Example 2
 * S = "abcd"
 * R = "bacd"
 * <p>
 * <p>
 * Example 3
 * S = "abcxcba"
 * R = "xbacbca"
 * <p>
 * Example 4
 * S = "facebook"
 * R = "eafcobok"
 */
public class Main {

    // Add any helper functions you may need here
    String findEncryptedWord(String s) {
        // Write your code here
        if (s.length() < 2) return s;

        String middle = "";
        String left = "";
        String right = "";

        if ((s.length() % 2) == 1) { // odd
            middle = "" + s.charAt(s.length() / 2);
            left = s.substring(0, s.length() / 2);
            right = s.substring(s.length() / 2 + 1);
        } else {
            middle = "" + s.charAt(s.length() / 2 - 1);
            left = s.substring(0, s.length() / 2 - 1);
            right = s.substring(s.length() / 2);
        }
        return middle
                + findEncryptedWord(left)
                + findEncryptedWord(right);
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String s_1 = "abc";
        String expected_1 = "bac";
        String output_1 = findEncryptedWord(s_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String expected_2 = "bacd";
        String output_2 = findEncryptedWord(s_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}