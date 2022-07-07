package tests;

import org.testng.annotations.Test;
import solver.ISolver;
import solver.Result;

import java.util.ArrayList;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void solve() {
        List<Integer> test1 = new ArrayList<>();
        test1.add(new Integer(2));
        test1.add(new Integer(45));
        test1.add(new Integer(4));
        test1.add(new Integer(5));
        test1.add(new Integer(8));

        ISolver solver = new Result();
        //assertEquals(5,solve(test1));

    }
}