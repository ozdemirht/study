import java.io.PrintStream;
import java.util.Arrays;

public class Main {
    static void printIntArray(PrintStream pout, int[] input){
        pout.println();
        Arrays.stream(input).limit(100).forEach(x-> pout.print(x+" "));
    }

    public static void main(String[] args) {
        int[] test_A = new int[]{3, 4, 4, 6, 1, 4, 4};
        Solution solver = new Solution();
        int[] answer = solver.solution(5, test_A);
        printIntArray(System.out, test_A);
        printIntArray(System.out, answer);

        test_A = new int[]{3, 4, 4, 6, 1, 4, 4, 6, 6, 6, 6, 6, 6, 6};

        long startTime = System.nanoTime();
        answer = solver.solution(5, test_A);
        long estimatedTime = System.nanoTime() - startTime;
        printIntArray(System.out, test_A);
        printIntArray(System.out, answer);
        System.out.println("\nTime(solution)="+estimatedTime);

        startTime = System.nanoTime();
        answer = solver.solution2(5, test_A);
        estimatedTime = System.nanoTime() - startTime;
        printIntArray(System.out, test_A);
        printIntArray(System.out, answer);
        System.out.println("\nTime(solution2)="+estimatedTime);

        startTime = System.nanoTime();
        answer = solver.solution3(5, test_A);
        estimatedTime = System.nanoTime() - startTime;
        printIntArray(System.out, test_A);
        printIntArray(System.out, answer);
        System.out.println("\nTime(solution3)="+(estimatedTime/1000)+"msec");

        test_A = new int[10001];
        int i, N = 5;
        for(i=0;i<test_A.length;i++) test_A[i]=((int)(113*Math.random()))%(N+1)+1;

        startTime = System.nanoTime();
        answer = solver.solution(N, test_A);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println();
        printIntArray(System.out, test_A);
        printIntArray(System.out, answer);
        //System.out.println("\nTime(solution) for "+test_A.length+"="+(estimatedTime/1000)+"msec");
        System.out.format("\nTime(solution) for %,d = %,.3f msec"
                            ,test_A.length,(float)(estimatedTime/1000));

        startTime = System.nanoTime();
        answer = solver.solution3(N, test_A);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println();
        printIntArray(System.out, test_A);
        printIntArray(System.out, answer);
        //System.out.println("\nTime(solution3) for "+test_A.length+"="+(estimatedTime/1000)+"msec");
        System.out.format("\nTime(solution3) for %,d = %,.3f msec"
                            ,test_A.length,(float)(estimatedTime/1000));

        test_A = new int[1000001];
        for(i=0;i<test_A.length;i++) test_A[i]=((int)(113*Math.random()))%(N+1)+1;

        startTime = System.nanoTime();
        answer = solver.solution(N, test_A);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println();
        printIntArray(System.out, test_A);
        printIntArray(System.out, answer);
        //System.out.println("\nTime(solution) for "+test_A.length+"="+(estimatedTime/1000)+"msec");
        System.out.format("\nTime(solution) for %,d = %,.3f msec",test_A.length,(float)(estimatedTime/1000));

        startTime = System.nanoTime();
        answer = solver.solution3(N, test_A);
        estimatedTime = System.nanoTime() - startTime;
        printIntArray(System.out, test_A);
        printIntArray(System.out, answer);
        //System.out.println("\nTime(solution3) for "+test_A.length+"="+(estimatedTime/1000)+"msec");
        System.out.format("\nTime(solution3) for %,d = %,.3f msec",test_A.length,(float)(estimatedTime/1000));

        startTime = System.nanoTime();
        answer = solver.solution4(N, test_A);
        estimatedTime = System.nanoTime() - startTime;
        printIntArray(System.out, test_A);
        printIntArray(System.out, answer);
        System.out.format("\nTime(solution4) for %,d = %,.3f msec",test_A.length,(float)(estimatedTime/1000));

    }
}