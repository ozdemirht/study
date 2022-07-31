

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

class Result {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */
    public static int sumOfDigits(String digits) {
        int value = 0;
        for (int i = 0; i < digits.length(); i++)
            value += (digits.charAt(i) - '0');
        return value;
    }

    public static int superDigit(int n) {
        if (n < 10) return n;
        return superDigit(sumOfDigits(n + ""));
    }

    public static int superDigit(String n, int k) {
        // Write your code here
        while ((k % 10) == 0) k = k / 10;
        return superDigit((sumOfDigits(n) * k));
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./test-input/input07.txt"));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        System.out.println(String.valueOf(result));

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
