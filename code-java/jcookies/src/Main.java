

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
    public static int cookies1(int k, List<Integer> A) {
        // Write your code here
        int answer = -1;
        int numberOfOperations = 0;
        int i, min=0;
        int minA1Value, minA1Index;
        int minA2Value, minA2Index;
        long total=0;

        for(Integer iVal:A) total+=iVal;
        if(total<k) return answer;

        do
        {
            if(A.size()<2) {
                if(A.size()>0 && A.get(0)>k)
                    answer=0;
                break;
            }
            if(A.get(0)<A.get(1)){
                minA1Index = 0;
                minA2Index = 1;
            } else {
                minA1Index = 1;
                minA2Index = 0;
            }
            minA1Value = A.get(minA1Index);
            minA2Value = A.get(minA2Index);
            for(i=2;i<A.size();i++) {
                if(A.get(i)<A.get(minA1Index)) {
                    minA2Index = minA1Index;
                    minA1Index = i;
                    minA1Value = A.get(minA1Index);
                    minA2Value = A.get(minA2Index);
                } else if(A.get(i)<A.get(minA2Index)) {
                    minA2Index = i;
                    minA2Value = A.get(minA2Index);
                }
            }
            if(minA1Value<k) {
                A.remove(Math.max(minA1Index,minA2Index));
                A.remove(Math.min(minA1Index,minA2Index));
                A.add(minA1Value+2*minA2Value);
                numberOfOperations++;

                // O(n) Find new min
                minA1Index = 0;
                for(i=1;i<A.size();i++)
                    if(A.get(i)<A.get(minA1Index))
                        minA1Index=i;
                // Update answer
                if(A.get(minA1Index)>=k)
                    answer = numberOfOperations;
            } else
                answer = numberOfOperations;
        } while(A.get(minA1Index)<k);

        return answer;
    }


    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies2(int k, List<Integer> A) {
        // Write your code here
        int answer = -1;
        int numberOfOperations = 0;
        int i, min=0;
        int minA1Value=-1, minA1Index;
        int minA2Value=-1, minA2Index;
        int total=0;

        do
        {
            if(A.size()<2) {
                //System.err.println("size=["+A.size()+"] k=["+k+"] minA1Value=["+minA1Value+"] numberOfOperations=["+numberOfOperations+"]");

                if(A.size()>0 && A.get(0)>k)
                    answer=0;
                break;
            }
            if(A.get(0)<A.get(1)){
                minA1Index = 0;
                minA2Index = 1;
            } else {
                minA1Index = 1;
                minA2Index = 0;
            }
            minA1Value = A.get(minA1Index);
            minA2Value = A.get(minA2Index);
            for(i=2;i<A.size();i++) {
                if(A.get(i)<A.get(minA1Index)) {
                    minA2Index = minA1Index;
                    minA1Index = i;
                    minA1Value = A.get(minA1Index);
                    minA2Value = A.get(minA2Index);
                } else if(A.get(i)<A.get(minA2Index)) {
                    minA2Index = i;
                    minA2Value = A.get(minA2Index);
                }
            }
            //System.err.println("size=["+A.size()+"] k=["+k+"] minA1Value=["+minA1Value+"] numberOfOperations=["+numberOfOperations+"]");
            if(minA1Value<k) {
                A.remove(Math.max(minA1Index,minA2Index));
                A.remove(Math.min(minA1Index,minA2Index));
                A.add(minA1Value+2*minA2Value);
                numberOfOperations++;

                //System.err.println("size=["+A.size()+"] k=["+k+"] minA1Value=["+minA1Value+"] numberOfOperations=["+numberOfOperations+"]");

                // O(n) Find new min
                minA1Index = 0;
                for(i=1;i<A.size();i++)
                    if(A.get(i)<A.get(minA1Index))
                        minA1Index=i;
                // Update answer
                if(A.get(minA1Index)>=k)
                    answer = numberOfOperations;
            } else
                answer = numberOfOperations;
        } while(A.get(minA1Index)<k);

        return answer;
    }

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        int answer = -1;
        int numberOfOperations = 0;
        int minA1Value, minA2Value;

        //
        if(A.size()<2) {
            if(A.size()>0 && A.get(0)>k)
                answer=0;
            return answer;
        }

        PriorityQueue minHeap = new PriorityQueue();
        for(Integer aVal: A) minHeap.add(aVal);

        while(minHeap.size()>1 && ((Integer)minHeap.peek())<k){
            minA1Value = (Integer)minHeap.poll();          // O(log n)
            minA2Value = (Integer)minHeap.poll();          // O(log n)
            minHeap.add(minA1Value+2*minA2Value); // O(log n)
            numberOfOperations++;
        }
        if(((Integer)minHeap.peek())>=k)
            answer=numberOfOperations;

        return answer;
    }

}

public class Main {

    public static int testFromInputFile(String fileName) throws IOException {
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

        int result = Result.cookies(k, A);
        System.out.println("File("+fileName+")=["+result+"] ");

        return result;

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
    }

    public static void testPerformanceInputFromFile(String fileName, int expected) throws IOException {
        long timeBegin, timeEnd;
        timeBegin=System.nanoTime();
        int numofops = testFromInputFile(fileName);
        timeEnd=System.nanoTime();
        System.err.println("File["+fileName+"] took "+(timeEnd-timeBegin)/1000+" msec!");
        System.err.println(numofops+" "+expected);
    }
    public static void main(String[] args) throws IOException {
        testPerformanceInputFromFile("./test-input/input11.txt",-1);
        testPerformanceInputFromFile("./test-input/input14.txt",99998);
        testPerformanceInputFromFile("./test-input/input18.txt",99999);
    }

}
