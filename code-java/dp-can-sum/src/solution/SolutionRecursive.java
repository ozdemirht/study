package solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionRecursive implements ISolution {

    @Override
    public boolean canSum(int targetNum, int[] numbers) {
        if (targetNum == 0) return true;
        if (targetNum < 0) return false;
        boolean answer = false;
        for (int i = 0; !answer && i < numbers.length; i++)
            answer = canSum(targetNum - numbers[i], numbers);
        return answer;
    }

    public List<Integer> howSum(int targetNum, int[] numbers) {
        Deque<Integer> myStack = new ArrayDeque<Integer>();
        List<Integer> response = null;
        boolean answer = howSum(targetNum, numbers, myStack);
        if (answer) response = new ArrayList<>(myStack);
        return response;
    }

    final boolean howSum(int targetNum, int[] numbers, Deque<Integer> stack) {
        if (targetNum == 0) return true;
        if (targetNum < 0) return false;
        boolean answer = false;
        for (int i = 0; !answer && i < numbers.length; i++) {
            stack.push(numbers[i]);
            answer = howSum(targetNum - numbers[i], numbers, stack);
            if (!answer) stack.pop();
        }
        return answer;
    }

}
