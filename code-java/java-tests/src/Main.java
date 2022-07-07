import java.util.*;

import static java.util.stream.Collectors.joining;

import solver.Result;

import tests.ITest;
import tests.Test1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Integer> test1 = new ArrayList<>();
        test1.add(new Integer(2));
        test1.add(new Integer(45));
        test1.add(new Integer(4));
        test1.add(new Integer(5));
        test1.add(new Integer(8));
        new Result().solve(test1);

        ITest test_1 = new Test1(11, 100);
        test_1.doTest(new Result());

        ITest test_2 = new Test1(21, 100);
        test_2.doTest(new Result());

        test_2 = new Test1(18, 100);
        test_2.doTest(new Result());
    }
}


