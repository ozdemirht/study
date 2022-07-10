package solution;

import java.util.HashMap;
import java.util.Map;

public class SolutionMemo implements ISolution {
    @Override
    public float findMaxRevenueByCuts(int lengthOfRawRod, StandardRods[] input) {
        Map<Integer, Float> memo = new HashMap<>();
        return findMaxRevenueByCuts(lengthOfRawRod, input, memo);
    }

    float findMaxRevenueByCuts(int lengthOfRawRod, StandardRods[] input, Map<Integer, Float> memo) {

        if (lengthOfRawRod < input[0].getLength())
            return 0;
        // memoization
        if (memo.containsKey(lengthOfRawRod))
            return (float) memo.get(lengthOfRawRod);

        float revenue = Float.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            // enough to make a cut
            if (lengthOfRawRod >= input[i].getLength()) {
                //System.out.println(lengthOfRawRod+" "+input[i].getLength()+" "+input[i].getPrice());
                float rev_i = input[i].getPrice()
                        + findMaxRevenueByCuts(lengthOfRawRod - input[i].getLength(), input);
                revenue = Math.max(revenue, rev_i);
            } else break;
        }
        memo.put(lengthOfRawRod, revenue);
        return revenue;
    }
}
