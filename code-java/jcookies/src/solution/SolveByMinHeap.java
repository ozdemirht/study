package solution;

import java.util.List;
import java.util.PriorityQueue;

public class SolveByMinHeap implements ICookies {
    @Override
    public int cookies(int k, List<Integer> A) {
        // Write your code here
        int answer = -1;
        int numberOfOperations = 0;
        int minA1Value, minA2Value;

        //
        if (A.size() < 2) {
            if (A.size() > 0 && A.get(0) > k)
                answer = 0;
            return answer;
        }

        PriorityQueue minHeap = new PriorityQueue();
        for (Integer aVal : A) minHeap.add(aVal);

        while (minHeap.size() > 1 && ((Integer) minHeap.peek()) < k) {
            minA1Value = (Integer) minHeap.poll();          // O(log n)
            minA2Value = (Integer) minHeap.poll();          // O(log n)
            minHeap.add(minA1Value + 2 * minA2Value); // O(log n)
            numberOfOperations++;
        }
        if (((Integer) minHeap.peek()) >= k)
            answer = numberOfOperations;

        return answer;
    }
}
