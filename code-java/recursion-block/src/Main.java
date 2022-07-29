import java.io.PrintStream;

public class Main {

    public static int test(String testLabel, PrintStream out, int n, int m){
        int result;
        result = Result.legoBlocks(n, m);
        out.println(testLabel+">> board("+n+","+m+")="+result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int result, n, m;
        n=2; m=3;
        result = Result.legoBlocks(n, m);
        System.out.println("board("+n+","+m+")="+result);

        test("Test-1",System.out,2,2);
        //test("Test-2",System.out,2,3);

    }
}