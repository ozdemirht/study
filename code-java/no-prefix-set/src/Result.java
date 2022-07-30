
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
        Map<String,Boolean> keyWords = new HashMap<>();
        //Map<String,Boolean> keyWords = new TreeMap<>();

        keyWords.put(words.get(0),Boolean.TRUE);
        for (int j = 1; j < words.size(); j++) {
            String currentWord = words.get(j);
            int lengthOfCurrent = currentWord.length();

            for (int i = 0; i < j; i++) {
                String wordI = words.get(i);
                int lengthOfWordI = wordI.length();

                int checkValue = -1;
                if (lengthOfCurrent == lengthOfWordI ) {
                    checkValue = 0;
                } else if (lengthOfCurrent > lengthOfWordI ) {
                    checkValue = 1;
                } else
                    checkValue = -1;
                //
                switch(checkValue){
                    case 0:
                        if(keyWords.containsKey(currentWord)) {
                            System.out.println("BAD SET");
                            System.out.println(currentWord);
                            return;
                        }
                        break;
                    case 1:
                        if(keyWords.containsKey(currentWord.substring(0, lengthOfWordI))) {
                            System.out.println("BAD SET");
                            System.out.println(currentWord);
                            return;
                        }
                        break;
                    default:
                        if (currentWord.compareTo(wordI.substring(0, lengthOfCurrent)) == 0) {
                            System.out.println("BAD SET");
                            System.out.println(currentWord);
                            return;
                        }
                }
            }
            keyWords.put(currentWord,Boolean.TRUE);
        }
        System.out.println("GOOD SET");
    }
    public static void noPrefix4(List<String> words) {
        boolean found = false;
        int i=0;
        String currentWord = "";
        PrefixTree pTree = new PrefixTree();

        // O(n * log (max(length(word[i]))) )
        for(i=0;!found && i<words.size(); i++) {
            currentWord = words.get(i);
            found = pTree.insertAndCheck(currentWord);
        }
        if(found) {
            System.out.println("BAD SET");
            System.out.println(currentWord);
        } else
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