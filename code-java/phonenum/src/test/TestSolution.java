package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import phonenum.Solution;

public class TestSolution {
    @Test
    public void test111(){
        List<String> answer = new ArrayList<>();
        Solution solver = new Solution();
        solver.solve("111",answer);
        System.out.print("\nInput:"+"111\nOutput:");
        answer.stream().forEach(x->System.out.print(x+" "));
        assertEquals(1,answer.size());
    }
    @Test
    public void test112(){
        List<String> answer = new ArrayList<>();
        Solution solver = new Solution();
        solver.solve("112",answer);
        System.out.print("\nInput:"+"112\nOutput:");
        answer.stream().forEach(x->System.out.print(x+" "));
        assertEquals(3,answer.size());
    }
    @Test
    public void test119(){
        List<String> answer = new ArrayList<>();
        Solution solver = new Solution();
        solver.solve("119",answer);
        System.out.print("\nInput:"+"119\nOutput:");
        answer.stream().forEach(x->System.out.print(x+" "));
        assertEquals(4,answer.size());
    }
    @Test
    public void test999(){
        List<String> answer = new ArrayList<>();
        Solution solver = new Solution();
        solver.solve("999",answer);
        System.out.print("\nInput:"+"999\nOutput:");
        answer.stream().limit(10).forEach(x->System.out.print(x+" "));
        assertEquals(4*4*4,answer.size());
    }
    @Test
    public void test6digits(){
        List<String> answer = new ArrayList<>();
        Solution solver = new Solution();
        solver.solve("129345",answer);
        System.out.print("\nInput:"+"129345\nOutput:\n"+answer.size());
        assertEquals(1*3*4*3*3*3,answer.size());
    }
}
