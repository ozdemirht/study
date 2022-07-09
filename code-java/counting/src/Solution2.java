import java.util.Arrays;

public class Solution2 extends SolutionBase implements ISolution {
    Solution2() {
        setName("Solution2");
    }
    @Override
    public final int[] solution(int N, int[] A) {
        final int[] answer = new int[N];
        int last_max_i = -1;
        int max_counter = 0;

        Arrays.fill(answer, 0);
        for (int i = 0; i < A.length; i++) { // O(m) where m=A.length
            if (A[i] < (N + 1)) {
                answer[A[i] - 1]++;
                max_counter = Math.max(max_counter, answer[A[i] - 1]);
            } else if ( (A[i] == (N + 1)) && (last_max_i == -1 || (i - last_max_i) > 1) ) {
                    Arrays.fill(answer, max_counter); // O(n) where n=counter.length
                    last_max_i = i;
            }
        }
        // O(m*n)
        return answer;
    }
}
