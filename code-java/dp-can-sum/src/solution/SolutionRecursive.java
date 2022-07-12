package solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionRecursive implements ISolution, IBestSumSolution {

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
    @Override
    public List<Integer> bestSum(int targetNum, int[] numbers) {
        Deque<Integer> myStack = new ArrayDeque<Integer>();
        List<Integer> response = new ArrayList<>();
        boolean answer = bestSum(targetNum, numbers, myStack, response);
        return response;
    }

    final boolean bestSum(int targetNum, int[] numbers, Deque<Integer> stack, List<Integer> best) {
        if (targetNum == 0) return true;
        if (targetNum < 0) return false;
        boolean answer = false;
        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
            answer = bestSum(targetNum - numbers[i], numbers, stack, best);
            if (answer && targetNum == numbers[i]) {
                //stack.stream().forEach(x->System.out.print(x+" "));
                //System.out.println();
                if (best.size() == 0)
                    best.addAll(stack.stream().collect(Collectors.toList()));
                else {
                    if (best.size() > stack.size())
                        best.clear();
                    best.addAll(stack.stream().collect(Collectors.toList()));
                }
            }
            stack.pop();
        }

        return best.size()>0;
    }

}
