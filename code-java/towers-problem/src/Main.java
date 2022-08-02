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

class Solution {

    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */
    public static boolean isThereAMove(int numberOfTowers, int[] board, int[] move){
        int i,j;
        boolean answer=false;
        int max=0;
        for(i=0;i<numberOfTowers;i++){
            if(board[i]>1){
                if( max<1 || board[i]>max) {
                    int m = board[i];
                    // brute force solution
                    for(j=(m-1);j>0;j--)
                        if((m%(m-j)==0) && j>max){
                            max=j;
                            move[0]=i;
                            move[1]=j;
                            answer=true;
                            break; // early exit
                        }
                }
            }
        }
        return answer;
    }
    public static int towerBreakers(int n, int m) {
        // Write your code here
        //System.out.println("n="+n+" m="+m); // original problem
        if(m<2) return 2; // winner is obvious when m=1
        // Change the number of towers because the result is the same
        if((n%2)==0) n=2;
        else n=3;
        //System.out.println("n="+n+" m="+m);

        int player = 0;
        int[] move = new int[2]; // tower, x-y
        int[] board = new int[n];
        for(int i=0;i<n;i++) board[i]=m;
        while(isThereAMove(n,board,move)){
            int tower = move[0];
            board[tower]=board[tower]-move[1];
            //System.err.println("Player["+player+"] tower="+tower+" remove="+move[1]);
            player = (player+1) % 2;
        }
        return (player==0?2:1);

    }

}

public class Main {
    public static void testFromFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        int t = Integer.parseInt(bufferedReader.readLine().trim());
        //if(t>30) t=30;

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);
                //System.out.println("n="+n+" m="+m);

                int result = Solution.towerBreakers(n, m);
                System.out.println("n="+n+" m="+m+" Player="+result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
    public static void main(String[] args) throws IOException {

        testFromFile("./test-input/input01.txt");

    }

    public static void main2(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./test-input/input01.txt"));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Solution.towerBreakers(n, m);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }

    public static void main1(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Solution.towerBreakers(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
