import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int N = Integer.parseInt(line);
        line = br.readLine();
        String[] numberString = line.split(" ");
        LinkedList array = new LinkedList();
        for(String nextString: numberString){
            array.add(Integer.parseInt(nextString));
        }
        int i, NthElement = -1;
        if(array.size()>=N){
            if(N>(array.size()/2))
                for(i=0; array.size()>0 && i<N;i++)
                    NthElement = ((Integer)array.removeLast()).intValue();
            else
                for(i=0; array.size()>0 && i<N;i++)
                    NthElement = ((Integer)array.removeFirst()).intValue();


            if(i!=N) NthElement = -1;
        }
        System.out.println(NthElement!=-1?NthElement:"NIL");
    }
}
