import java.io.PrintStream;
import java.util.Arrays;

public class Main {

    public static void print(int[] test, int[] output, PrintStream out){
        out.print("\nInput: [");
        Arrays.stream(test).forEach(x->out.print(x+","));
        out.print("]\nOutput: [");
        Arrays.stream(output).forEach(x->out.print(x+","));
        out.print("]");
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Solution solver = new Solution();

        int[] test1 = new int[]{1,3,2,1,3,2,2};
        int[] answer = solver.numberOfPairs(test1);

        print(test1,answer,System.out);

        test1 = new int[]{1,1};
        answer = solver.numberOfPairs(test1);

        print(test1,answer,System.out);

        test1 = new int[]{};
        answer = solver.numberOfPairs(test1);
        print(test1,answer,System.out);

    }
}