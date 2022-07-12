package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import solution.ICanConstructSolution;
import solution.ICountConstruct;
import solution.SolutionToCanConstructMemo;
import solution.SolutionToCanConstructRecursive;

import java.util.ArrayList;
import java.util.List;

public class TestCountConstructSolution {
    static class TestProblem{
        String targetWord;
        String[] wordsBank;
        int expected;

        TestProblem(String targetWord, String[] wordsBank, int expected){
            this.expected=expected;
            this.targetWord=targetWord;
            this.wordsBank=wordsBank;
        }
    }
    static List<TestCountConstructSolution.TestProblem> testps = new ArrayList<>();
    static {
        testps.add(new TestCountConstructSolution.TestProblem("",new String[]{"a","b"}, 0));
        testps.add(new TestCountConstructSolution.TestProblem("abcdef",new String[]{"ab","abc","cd","def","abcd"}, 1));
        testps.add(new TestCountConstructSolution.TestProblem("skateboard",new String[]{"bo","rd","ate","t","ska","sk","boar"}, 0));
        testps.add(new TestCountConstructSolution.TestProblem("enterapotentpot",new String[]{"a","p","ent","enter","ot","o","t"}, 4));
    }
    @Test
    public void testCountConstructRecursive(){
        testCountConstructRecursiveBase(testps.get(0));
    }
    @Test
    public void testCountConstructRecursiveP1(){
        testCountConstructRecursiveBase(testps.get(1));
    }
    @Test
    public void testCountConstructRecursiveNG1(){
        testCountConstructRecursiveBase(testps.get(2));
    }
    @Test
    public void testCountConstructRecursiveP2(){
        testCountConstructRecursiveBase(testps.get(3));
    }

    final void testCountConstructRecursiveBase(TestCountConstructSolution.TestProblem test){
        ICountConstruct solver = new SolutionToCanConstructRecursive();
        int answer = solver.countConstruct(test.targetWord,test.wordsBank);
        assertEquals(test.expected,answer);
    }

}
