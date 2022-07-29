import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] words = {"abcd","bcd","abcde","bcde"};
        Result.noPrefix(Arrays.stream(words).collect(Collectors.toList()));

        words = new String[]{"ab","bc","cd"};
        Result.noPrefix(Arrays.stream(words).collect(Collectors.toList()));

        words = new String[]{"aab","defgab","abcde","aabcde","cedaaa","bbbbbbbbbb","jabjjjad"};
        Result.noPrefix(Arrays.stream(words).collect(Collectors.toList()));

        words = new String[]{"aab","aac","aacghgh","aabghgh"};
        Result.noPrefix(Arrays.stream(words).collect(Collectors.toList()));

    }
}