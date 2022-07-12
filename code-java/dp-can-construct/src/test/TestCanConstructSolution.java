package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import solution.ICanConstructSolution;
import solution.SolutionToCanConstructMemo;
import solution.SolutionToCanConstructRecursive;

import java.util.ArrayList;
import java.util.List;

public class TestCanConstructSolution {
    static class TestProblem{
        String targetWord;
        String[] wordsBank;
        boolean expected;

        TestProblem(String targetWord, String[] wordsBank, boolean expected){
            this.expected=expected;
            this.targetWord=targetWord;
            this.wordsBank=wordsBank;
        }
    }
    static List<TestProblem> testps = new ArrayList<>();
    static {
        testps.add(new TestProblem("",new String[]{"a","b"}, true));
        testps.add(new TestProblem("abcdef",new String[]{"ab","abc","cd","def","abcd"}, true));
        testps.add(new TestProblem("skateboard",new String[]{"bo","rd","ate","t","ska","sk","boar"}, false));
        testps.add(new TestProblem("enterapotentpot",new String[]{"a","p","ent","enter","ot","o","t"}, true));
    }
    @Test
    public void testCanConstructRecursive(){
        testCanConstructRecursiveBase(testps.get(0));
    }
    @Test
    public void testCanConstructRecursiveP1(){
        testCanConstructRecursiveBase(testps.get(1));
    }
    @Test
    public void testCanConstructRecursiveNG1(){
        testCanConstructRecursiveBase(testps.get(2));
    }
    @Test
    public void testCanConstructRecursiveP2(){
        testCanConstructRecursiveBase(testps.get(3));
    }

    final void testCanConstructRecursiveBase(TestProblem test){
        ICanConstructSolution solver = new SolutionToCanConstructRecursive();
        boolean answer = solver.canConstruct(test.targetWord,test.wordsBank);
        assertEquals(test.expected,answer);
    }
    @Test
    public void testCanConstructMemo(){
        testCanConstructMemoBase(testps.get(0));
    }
    @Test
    public void testCanConstructMemoP1(){
        testCanConstructMemoBase(testps.get(1));
    }
    @Test
    public void testCanConstructMemoP2(){
        testCanConstructMemoBase(testps.get(3));
    }
    @Test
    public void testCanConstructMemoNG1(){
        testCanConstructMemoBase(testps.get(2));
    }
    final void testCanConstructMemoBase(TestProblem test){
        ICanConstructSolution solver = new SolutionToCanConstructMemo();
        boolean answer = solver.canConstruct(test.targetWord,test.wordsBank);
        assertEquals(test.expected,answer);
    }

}
