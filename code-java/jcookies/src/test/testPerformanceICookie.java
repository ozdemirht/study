package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import solution.ICookies;
import solution.SolveByMinHeap;
import solution.SolveByScan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class testPerformanceICookie {
    static int testFromInputFile(ICookies solver, String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        bufferedReader.close();

        int result = solver.cookies(k, A);
        System.out.println("File("+fileName+")=["+result+"] ");

        return result;

    }

    static void testPerformanceInputFromFile(ICookies solver, String fileName, int expected) throws IOException {
        long timeBegin, timeEnd;
        timeBegin=System.nanoTime();
        int numofops = testFromInputFile(solver,fileName);
        timeEnd=System.nanoTime();
        System.err.println("File["+fileName+"] took "+(timeEnd-timeBegin)/1000+" msec!");
        System.err.println(numofops+" "+expected);
        assertEquals(expected,numofops);
    }

    @Test
    public void testInput11() throws IOException {
        ICookies solver = new SolveByScan();
        testPerformanceInputFromFile(solver,"./test-input/input11.txt",-1);
        testPerformanceInputFromFile(solver,"./test-input/input14.txt",99998);
        testPerformanceInputFromFile(solver,"./test-input/input18.txt",99999);
    }

    @Test
    public void testByMinHeapOnInput11() throws IOException {
        ICookies solver = new SolveByMinHeap();
        testPerformanceInputFromFile(solver,"./test-input/input11.txt",-1);
        testPerformanceInputFromFile(solver,"./test-input/input14.txt",99998);
        testPerformanceInputFromFile(solver,"./test-input/input18.txt",99999);
    }
}
