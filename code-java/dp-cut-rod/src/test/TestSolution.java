package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import solution.*;


public class TestSolution {

    static StandardRods[] sellable ;
    static {
        sellable = new StandardRods[] { new StandardRods(1,1),
                                        new StandardRods(2,3),
                                        new StandardRods(4,4),
                                        new StandardRods(5,6)
                                    };
    }

    @Test
    public void testRecursive(){
        ISolution solver = new Solution();
        float revenue;
        revenue=solver.findMaxRevenueByCuts(5,sellable);
        System.out.format("\nRevenue from rod("+5+") is %.3f",revenue);
        assertEquals(7,revenue);
    }
    @Test
    public void testMemo(){
        ISolution solver = new SolutionMemo();
        float revenue;
        revenue=solver.findMaxRevenueByCuts(5,sellable);
        System.out.format("\nRevenue from rod("+5+") is %.3f",revenue);
        assertEquals(7,revenue);
    }
    @Test
    public void testTabularFromBottom(){
        ISolution solver = new SolutionTabularFromBottom();
        float revenue;
        revenue=solver.findMaxRevenueByCuts(5,sellable);
        System.out.format("\nRevenue from rod("+5+") is %.3f",revenue);
        assertEquals(7,revenue);
    }

}
