import java.util.Arrays;

public class Solution1 extends SolutionBase implements ISolution {

    Solution1(){
        setName("Solution1");
    }

    @Override
    public final int[] solution(int N, int[] A) {
        final int[] answer = new int[N];
        int last_max_i = -1;
        int max_counter = 0;
        int i;
        final int N_plus_1 = N + 1;

        Arrays.fill(answer, 0);
        for (i = 0; i < A.length; i++) { // O(m) where m=A.length
            if (A[i] < N_plus_1) {
                answer[A[i] - 1]++;
                max_counter = (max_counter < answer[A[i] - 1] ? answer[A[i] - 1] : max_counter);
            } else if ((A[i] == N_plus_1) && (last_max_i == -1 || (i - last_max_i) > 1) ) {
                    Arrays.fill(answer, max_counter); // O(n) where n=counter.length
                    last_max_i = i;
            }
        }
        return answer; // O(m*n)
    }
}
