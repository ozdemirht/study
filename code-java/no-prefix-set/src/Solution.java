import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Solution {

    public static List<String> readTestInputFromFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        bufferedReader.close();

        return words;
    }
    public static void testWordList(String fileName, List<String> words){
        long testBegin = System.nanoTime();
        Result.noPrefix3(words);
        long testEnd = System.nanoTime();
        System.out.println("Took["+fileName+",N="+words.size()+",noPrefix3] "+(testEnd-testBegin)/1000+" msec");

        testBegin = System.nanoTime();
        Result.noPrefix(words);
        testEnd = System.nanoTime();
        System.out.println("Took["+fileName+",N="+words.size()+",noPrefix] "+(testEnd-testBegin)/1000+" msec");

        testBegin = System.nanoTime();
        Result.noPrefix4(words);
        testEnd = System.nanoTime();
        System.out.println("Took["+fileName+",N="+words.size()+",noPrefix4] "+(testEnd-testBegin)/1000+" msec");

    }


    public static void testInputFile(String fileName) throws IOException {
        List<String> words = readTestInputFromFile(fileName);
        testWordList(fileName,words);
    }
    public static void main(String[] args) throws IOException {
        testInputFile("./input-test/input01.txt");
        testInputFile("./input-test/input02.txt");
        testInputFile("./input-test/input08.txt");
        testInputFile("./input-test/input37.txt");
    }

    public static void main1(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //BufferedReader bufferedReader = new BufferedReader(new FileReader("./input-test/input08.txt"));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("./input-test/input01.txt"));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("./input-test/input02.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./input-test/input37.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());
        long testBegin = System.nanoTime();
        Result.noPrefix(words);
        long testEnd = System.nanoTime();
        System.out.println(" Took "+(testEnd-testBegin)/1000+" msec");

        bufferedReader.close();
    }
}
