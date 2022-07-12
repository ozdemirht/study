package solution;

import java.util.*;
import java.util.stream.Collectors;

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
        Deque<Integer> myStack = new ArrayDeque<Integer>();
        List<Integer> response = null;
        Map<Integer,Boolean> memo = new HashMap<>();

        boolean answer = howSumMemo(targetNum, numbers, memo, myStack);
        if (answer) response = new ArrayList<>(myStack);
        return response;
    }

    final boolean howSumMemo(int targetNum, int[] numbers, Map<Integer,Boolean> memo, Deque<Integer> stack) {
        if (targetNum == 0) return true;
        if (targetNum < 0) return false;
        if(memo.containsKey(targetNum))
            return memo.get(targetNum);
        boolean answer = false;
        for (int i = 0; !answer && i < numbers.length; i++) {
            stack.push(numbers[i]);
            answer = howSumMemo(targetNum - numbers[i], numbers, memo, stack);
            if (!answer) stack.pop();
        }
        memo.put(targetNum,answer);
        return answer;
    }

}
