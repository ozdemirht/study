package solution;

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
}
