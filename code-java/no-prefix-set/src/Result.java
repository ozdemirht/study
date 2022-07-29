
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

public class Result {

    /*
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */

    public static void noPrefix(List<String> words) {
        // Write your code here
        for (int j = 1; j < words.size(); j++) {
            String currentWord = words.get(j);
            for (int i = 0; i < j; i++) {
                String wordI = words.get(i);
                int k=0;
                int minLength = Math.min(currentWord.length(),wordI.length());
                for(k=0; k<minLength ; k++)
                    if(wordI.charAt(k)!=currentWord.charAt(k)) break;
                if (k==minLength) {
                    System.out.println("BAD SET");
                    System.out.println(currentWord);
                    return;
                }
            }
        }
        System.out.println("GOOD SET");
    }

    public static String revisedToInt(String words) {
        String answer = words;
        char[][] myMap =  {
            {'a', '0'},{'b', '1'},{'c', '2'},{'d', '3'},{'e', '4'},
            {'f', '5'},{'g', '6'},{'h', '7'},{'i', '8'},{'j', '9'}
        } ;
        for (int i = 0; i < 10; i++) answer=answer.replace(myMap[i][0], myMap[i][1]);
        return answer;
    }
    public static void noPrefix3(List<String> words) {
        // Write your code here
        for (int j = 1; j < words.size(); j++) {
            String currentWord = revisedToInt(words.get(j));
            System.out.println(words.get(j));
            System.out.println(currentWord);
            for (int i = 0; i < j; i++) {
                String wordI = revisedToInt(words.get(i));
                int min=Math.min(currentWord.length(),wordI.length());
                if (Long.parseLong(currentWord.substring(0,min))==Long.parseLong(wordI.substring(0,min))) {
                    System.out.println("BAD SET");
                    System.out.println(currentWord);
                    return;
                }
            }
        }
        System.out.println("GOOD SET");
    }

    public static void noPrefix2(List<String> words) {
        // Write your code here
        for (int j = 1; j < words.size(); j++) {
            String currentWord = words.get(j);
            for (int i = 0; i < j; i++) {
                String wordI = words.get(i);
                if (currentWord.length() >= wordI.length()) {
                    if (currentWord.startsWith(wordI)) {
                        System.out.println("BAD SET");
                        System.out.println(currentWord);
                        return;
                    }
                } else if (wordI.startsWith(currentWord)) {
                    System.out.println("BAD SET");
                    System.out.println(currentWord);
                    return;
                }
            }
        }
        System.out.println("GOOD SET");
    }

}