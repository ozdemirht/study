package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionMemo implements ISolution {

    @Override
    public boolean canSum(int targetNum, int[] numbers) {
        Map<Integer,Boolean> memo = new HashMap<>();
        return canSum(targetNum,numbers,memo);
    }
    boolean canSum(int targetNum, int[] numbers, Map<Integer,Boolean> memo) {
        if (targetNum == 0) return true;
        if (targetNum < 0) return false;
        if(memo.containsKey(targetNum))
            return memo.get(targetNum);
        boolean answer = false;
        for (int i = 0; !answer && i < numbers.length; i++)
            answer = canSum(targetNum - numbers[i], numbers);
        memo.put(targetNum,answer);
        return answer;
    }

    @Override
    public List<Integer> howSum(int targetNum, int[] numbers) {
        return new ArrayList<>();
    }

}
