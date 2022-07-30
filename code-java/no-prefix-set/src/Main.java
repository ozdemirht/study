import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static void testWordList(String testLabel, List<String> words){
        long testBegin = System.nanoTime();
        Result.noPrefix(words);
        long testEnd = System.nanoTime();
        System.out.println("Took[.,N="+words.size()+","+testLabel+"] "+(testEnd-testBegin)/1000+" msec");
    }
    static void testWordList3(String testLabel, List<String> words){
        long testBegin = System.nanoTime();
        Result.noPrefix3(words);
        long testEnd = System.nanoTime();
        System.out.println("Took[.,N="+words.size()+","+testLabel+"] "+(testEnd-testBegin)/1000+" msec");
    }
    static void testWordList4(String testLabel, List<String> words){
        long testBegin = System.nanoTime();
        Result.noPrefix4(words);
        long testEnd = System.nanoTime();
        System.out.println("Took[.,N="+words.size()+","+testLabel+"] "+(testEnd-testBegin)/1000+" msec");
    }

    public static void main(String[] args) {

        String[] words = {"abcd","bcd","abcde","bcde"};
        testWordList("noPrefix", Arrays.stream(words).collect(Collectors.toList()));
        testWordList4("noPrefix4", Arrays.stream(words).collect(Collectors.toList()));

        words = new String[]{"ab","bc","cd"};
        testWordList("noPrefix", Arrays.stream(words).collect(Collectors.toList()));
        testWordList4("noPrefix4", Arrays.stream(words).collect(Collectors.toList()));

        words = new String[]{"abcd","bcde","bcd","abcde"};
        testWordList("noPrefix", Arrays.stream(words).collect(Collectors.toList()));
        testWordList4("noPrefix4", Arrays.stream(words).collect(Collectors.toList()));
        testWordList3("noPrefix3", Arrays.stream(words).collect(Collectors.toList()));
        /*
        words = new String[]{"aab","defgab","abcde","aabcde","cedaaa","bbbbbbbbbb","jabjjjad"};
        testWordList("noPrefix", Arrays.stream(words).collect(Collectors.toList()));
        testWordList4("noPrefix4", Arrays.stream(words).collect(Collectors.toList()));

        words = new String[]{"aab","aac","aacghgh","aabghgh"};
        testWordList("noPrefix", Arrays.stream(words).collect(Collectors.toList()));
        testWordList4("noPrefix4", Arrays.stream(words).collect(Collectors.toList()));
        */
    }
}