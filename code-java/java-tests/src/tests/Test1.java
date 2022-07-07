package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import solver.ISolver;

public class Test1 implements ITest{
        List<Integer> testData = new ArrayList<>();

        public Test1(int size, int maxValue){
            for(int i=0;i<size;i++){
                testData.add(new Integer((int)(Math.random()*maxValue)));
            }
        }
        void printTestData(List<Integer> data) {
            System.out.print("[");
            for(Integer v: data){
                System.out.print(v+" ");
            }
            System.out.println("] ");
        }
        public boolean doTest(ISolver Result){
            Integer median = Result.solve(testData);
            printTestData(this.testData);
            printTestData(this.testData.stream().sorted().collect(Collectors.toList()));
            System.out.println("Median is "+median);
            return true;
        }
}
