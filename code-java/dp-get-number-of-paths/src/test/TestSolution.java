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
        int answer = solver.solve(2,3);
        System.out.println("The number of unique paths in (m,n) is "+answer);
        assertEquals(3,answer);
    }
    @Test
    public void testMemo(){
        ISolution solver = new SolutionMemo();
        int answer = solver.solve(2,3);
        System.out.println("The number of unique paths in (m,n) is "+answer);
        assertEquals(3,answer);
    }
    @Test
    public void testSolutionTabular(){
        ISolution solver = new SolutionTabular();
        int answer = solver.solve(2,3);
        System.out.println("The number of unique paths in (m,n) is "+answer);
        assertEquals(3,answer);
    }
}
