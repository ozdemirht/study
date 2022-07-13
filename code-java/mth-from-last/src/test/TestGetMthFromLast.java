package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import solution.GetMthFromLastV1;
import solution.IGetMthFromLast;

import java.util.LinkedList;

public class TestGetMthFromLast {

    @Test
    public void testSmall_P1() {

        int[] test1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i, M=2;
        LinkedList input = new LinkedList();
        for (i = 0; i < test1.length; i++) input.add(test1[i]);

        IGetMthFromLast solver = new GetMthFromLastV1();
        Integer answer = solver.getMthFromLast(input, M);
        System.out.println("\n"+M+"# " + answer);
        assertEquals(test1[test1.length-M],answer);
    }
    @Test
    public void testSmall_P2() {

        int[] test1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i, M=1;
        LinkedList input = new LinkedList();
        for (i = 0; i < test1.length; i++) input.add(test1[i]);

        IGetMthFromLast solver = new GetMthFromLastV1();
        Integer answer = solver.getMthFromLast(input, M);
        System.out.println("\n"+M+"# " + answer);
        assertEquals(test1[test1.length-M],answer);
    }
    @Test
    public void testSmall_P3() {

        int[] test1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i, M=9;
        LinkedList input = new LinkedList();
        for (i = 0; i < test1.length; i++) input.add(test1[i]);

        IGetMthFromLast solver = new GetMthFromLastV1();
        Integer answer = solver.getMthFromLast(input, M);
        System.out.println("\n"+M+"# " + answer);
        assertEquals(test1[test1.length-M],answer);
    }
    @Test
    public void testSmall_P4() {

        int[] test1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i, M=10;
        LinkedList input = new LinkedList();
        for (i = 0; i < test1.length; i++) input.add(test1[i]);

        IGetMthFromLast solver = new GetMthFromLastV1();
        Integer answer = solver.getMthFromLast(input, M);
        System.out.println("\n"+M+"# " + answer);
        assertEquals(test1[test1.length-M],answer);
    }
    @Test
    public void testSmall_NG_IndexOutOfBounds_1() {

        int[] test1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i, M=20;
        LinkedList input = new LinkedList();
        for (i = 0; i < test1.length; i++) input.add(test1[i]);

        IGetMthFromLast solver = new GetMthFromLastV1();
        Integer answer = solver.getMthFromLast(input, M);
        System.out.println("\n"+M+"# " + (answer==null?"NIL":answer));
        assertEquals(null,answer);
    }

}
