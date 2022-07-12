package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import solution.*;

import java.util.ArrayList;
import java.util.List;

public class TestSolution {

    @Test
    public void testSolutionRecursive(){
        ISolution solver = new SolutionRecursive();
        boolean answer = solver.canSum(7,new int[]{5,3,4,7});
        assertEquals(true,answer);
    }
    @Test
    public void testSolutionRecursiveNG1(){
        ISolution solver = new SolutionRecursive();
        boolean answer = solver.canSum(7,new int[]{2,4});
        assertEquals(false,answer);
    }
    @Test
    public void testSolutionMemo(){
        ISolution solver = new SolutionMemo();
        boolean answer = solver.canSum(7,new int[]{5,3,4,7});
        assertEquals(true,answer);
    }
    @Test
    public void testSolutionMemoNG1(){
        ISolution solver = new SolutionMemo();
        boolean answer = solver.canSum(7,new int[]{2,4});
        assertEquals(false,answer);
    }
    @Test
    public void testSolutionTabulation(){
        ISolution solver = new SolutionTabular();
        boolean answer = solver.canSum(7,new int[]{5,3,4,7});
        assertEquals(true,answer);
    }
    @Test
    public void testSolutionTabulationNG1(){
        ISolution solver = new SolutionTabular();
        boolean answer = solver.canSum(7,new int[]{2,4});
        assertEquals(false,answer);
    }

    @Test
    public void testSolutionRecursiveHowSum(){
        testSolutionHowSumBase(new SolutionRecursive(), 7, new int[]{5,3,4,7}, true);
    }
    @Test
    public void testSolutionRecursiveHowSum_NG1(){
        testSolutionHowSumBase(new SolutionRecursive(), 7, new int[]{2,4}, false);
    }
    @Test
    public void testSolutionMemoHowSum(){
        testSolutionHowSumBase(new SolutionMemo(), 7, new int[]{5,3,4,7}, true);
    }

    @Test
    public void testSolutionMemoHowSum_NG1() {
        testSolutionHowSumBase(new SolutionMemo(), 7, new int[]{2, 4}, false);
    }

    final void testSolutionHowSumBase(ISolution solver, int targetNum, int[] numbers, boolean expected) {
        List<Integer> answer = solver.howSum(targetNum, numbers);
        if (answer == null) answer = new ArrayList<>();
        assertEquals(expected, !answer.isEmpty());

        System.out.print("\nAnswer: ");
        if (!answer.isEmpty()) answer.stream().forEach(x -> System.out.print("[" + x + "] "));
    }

    @Test
    public void testSolutionRecursiveBestSum(){
        testSolutionBestSumBase(new SolutionRecursive(), 7, new int[]{5,3,4,7}, true);
    }

    final void testSolutionBestSumBase(IBestSumSolution solver, int targetNum, int[] numbers, boolean expected) {
        List<Integer> answer = solver.bestSum(targetNum, numbers);
        if (answer == null) answer = new ArrayList<>();
        assertEquals(expected, !answer.isEmpty());

        System.out.print("\nAnswer: ");
        if (!answer.isEmpty()) answer.stream().forEach(x -> System.out.print("[" + x + "] "));
    }

}
