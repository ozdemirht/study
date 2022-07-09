import java.io.PrintStream;
import java.util.Arrays;

public class Main {
    static void printIntArray(PrintStream pout, int[] input){
        pout.println();
        Arrays.stream(input).limit(100).forEach(x-> pout.print(x+" "));
    }

    static void testSolution(ISolution solver, int N, int[] data){
        long startTime = System.nanoTime();
        int[] answer = solver.solution(N, data);
        long estimatedTime = System.nanoTime() - startTime;
        //printIntArray(System.out, data);
        //printIntArray(System.out, answer);
        System.out.format("\nTime("+solver.getName()+") for %,d = %,.3f msec",data.length,(float)(estimatedTime/1000));
    }
    static void testCorrectness(ISolution solver, int N, int[] data, int[] expected, PrintStream pout){
        int[] answer = solver.solution(N, data);
        printIntArray(pout, data);
        printIntArray(pout, answer);
        pout.print("isPassed?= "+Arrays.equals(answer,expected));
    }

    public static void main(String[] args) {
        ISolution solver1 = new Solution1();
        ISolution solver2 = new Solution2();
        ISolution solver3 = new Solution3();
        ISolution solver4 = new Solution4();
        ISolution[] solvers = new ISolution[]{solver1, solver2, solver3, solver4};
        ISolution solver = solver1;

        int i, N = 5;

        int[] test_A = new int[]{3, 4, 4, 6, 1, 4, 4};
        testCorrectness(solver,N,test_A,new int[]{3,2,2,4,2},System.out);

        test_A = new int[]{3, 4, 4, 6, 1, 4, 4, 4, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,};
        testCorrectness(solver,N,test_A,new int[]{5,5,5,5,5},System.out);

        test_A = new int[]{3, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,3,3};
        testCorrectness(solver,N,test_A,new int[]{1,1,3,1,1},System.out);

        test_A = new int[]{6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,6, 6, 6, 6, 6, 6,6, 6, 6, 6, 6, 6};
        testCorrectness(solver,N,test_A,new int[]{0,0,0,0,0},System.out);

        // test large
        test_A = new int[10001];
        for (i = 0; i < test_A.length; i++)
            test_A[i] = ((int) (113 * Math.random())) % (N + 1) + 1;
        for (ISolution sut : solvers)
            testSolution(sut, N, test_A);
        for (ISolution sut : solvers)
            testSolution(sut, N, test_A);

        // test very large
        test_A = new int[1000001];
        for (i = 0; i < test_A.length; i++)
            test_A[i] = ((int) (113 * Math.random())) % (N + 1) + 1;

        for (i = 0; i < 100000; i++)
            test_A[(int)(test_A.length*Math.random())%test_A.length] = N + 1;

        for (ISolution sut : solvers)
            testSolution(sut, N, test_A);
        for (ISolution sut : solvers)
            testSolution(sut, N, test_A);

        test_A = new int[5000001];
        for (i = 0; i < test_A.length; i++)
            test_A[i] = ((int) (113 * Math.random())) % (N + 1) + 1;
        for (i = 0; i < 500000; i++)
            test_A[(int)(test_A.length*Math.random())%test_A.length] = N + 1;

        for (ISolution sut : solvers)
            testSolution(sut, N, test_A);
        for (ISolution sut : solvers)
            testSolution(sut, N, test_A);
    }
}