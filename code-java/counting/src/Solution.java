import java.io.PrintStream;
import java.util.Arrays;

public class Solution {

    public final int[] solution(int N, int[] A) {
        final int[] answer = new int[N];
        int last_max_i = -1;
        int max_counter = 0;
        int i;
        final int N_plus_1 = N+1;
        Arrays.fill(answer, 0);
        for (i = 0; i < A.length; i++) { // O(m) where m=A.length
            if (A[i] < N_plus_1) {
                answer[A[i] - 1]++;
                //max_counter = Math.max(max_counter,answer[A[i]-1]);
                max_counter = (max_counter<answer[A[i]-1]?answer[A[i]-1]:max_counter);
            } else if (A[i] == N_plus_1)
                if(last_max_i == -1 || (i-last_max_i)>1) {
                    Arrays.fill(answer, max_counter); // O(n) where n=counter.length
                    last_max_i = i;
                }
        }
        return answer; // O(m*n)
    }
    public final int[] solution2(int N, int[] A) {
        final int[] answer = new int[N];
        int last_max_i = -1;
        int max_counter = 0;

        Arrays.fill(answer, 0);
        for (int i = 0; i < A.length; i++) { // O(m) where m=A.length
            if (A[i] < (N + 1)) {
                answer[A[i] - 1]++;
                max_counter = Math.max(max_counter,answer[A[i]-1]);
                //max_counter = (max_counter<answer[A[i]-1]?answer[A[i]-1]:max_counter);
            } else if (A[i] == (N + 1))
                if(last_max_i == -1 || (i-last_max_i)>1) {
                    Arrays.fill(answer, max_counter); // O(n) where n=counter.length
                    last_max_i = i;
                }// else System.out.println("skipped");
        }
        // O(m*n)
        return answer;
    }

    public final int[] solution3(int N, int[] A) {
        final int[] answer = new int[N];
        int last_max_i = -1;
        int max_counter = 0;
        //final int N_plus_1 = N+1;

        fillIntArray(answer, 0);
        for (int i = 0; i < A.length; i++) { // O(m) where m=A.length
            if (A[i] < (N+1)) {
                answer[A[i] - 1]++;
                //max_counter = Math.max(max_counter,answer[A[i]-1]);
                max_counter = (max_counter<answer[A[i]-1]?answer[A[i]-1]:max_counter);
            } else if (A[i] == (N+1))
                if(last_max_i == -1 || (i-last_max_i)>1) {
                    //Arrays.fill(answer, max_counter); // O(n) where n=counter.length
                    fillIntArray(answer, max_counter);
                    last_max_i = i;
                }// else System.out.println("skipped");
        }
        // O(m*n)
        return answer;
    }

    public final int[] solution4(int N, int[] A) {
        final int[] answer = new int[N];
        int last_max_i = -1;
        int max_counter = 0;
        final int N_plus_1 = N+1;

        fillIntArray(answer, 0);
        for (int i = 0; i < A.length; i++) { // O(m) where m=A.length
            if (A[i] < (N_plus_1)) {
                answer[A[i] - 1]++;
                //max_counter = Math.max(max_counter,answer[A[i]-1]);
                max_counter = (max_counter<answer[A[i]-1]?answer[A[i]-1]:max_counter);
            } else if (A[i] == (N_plus_1))
                if(last_max_i == -1 || (i-last_max_i)>1) {
                    //Arrays.fill(answer, max_counter); // O(n) where n=counter.length
                    fillIntArray(answer, max_counter);
                    last_max_i = i;
                }// else System.out.println("skipped");
        }
        // O(m*n)
        return answer;
    }

    private final void fillIntArray(int[] array, int value) {
        final int len = array.length;

        if (len > 0){
            array[0] = value;
        }

        //Value of i will be [1, 2, 4, 8, 16, 32, ..., len]
        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, ((len - i) < i) ? (len - i) : i);
        }
    }
}
