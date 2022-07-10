package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import solution.ISolution;
import solution.SolutionMemo;
import solution.SolutionRecursive;
import solution.SolutionTabular;

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
}
