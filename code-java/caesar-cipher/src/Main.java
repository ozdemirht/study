import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.lang.StringBuffer;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String alphabetU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer answer = new StringBuffer(s.length());
        for (int i = 0; i < s.length(); i++)
            if (Character.isLowerCase(s.charAt(i)))
                answer.append(alphabet.charAt((s.charAt(i) - 'a' + k) % alphabet.length()));
            else if (Character.isUpperCase(s.charAt(i)))
                answer.append(alphabetU.charAt((s.charAt(i) - 'A' + k) % alphabetU.length()));
            else
                answer.append(s.charAt(i));

        return answer.toString();
    }

}

public class Main {

    public static void testAllSmallLetters(String testInput, int k) {
        String testOutput;
        testOutput = Result.caesarCipher(testInput, k);
        System.out.println("Cipher(" + testInput + ")=[" + testOutput + "]");
    }

    public static void main(String[] args) throws IOException {
        testAllSmallLetters("abc", 1);
        testAllSmallLetters("xyz", 1);
        testAllSmallLetters("xyz", 0);
        testAllSmallLetters("Xyz", 0);
        testAllSmallLetters("Xyz", 1);
        testAllSmallLetters("middle-Outz", 2);
        testAllSmallLetters("Always-Look-on-the-Bright-Side-of-Life", 5);
    }

    public static void main1(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
