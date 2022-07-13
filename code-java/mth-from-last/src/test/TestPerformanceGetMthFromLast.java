package test;

import org.junit.jupiter.api.Test;
import solution.GetMthFromLastV1;
import solution.IGetMthFromLast;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPerformanceGetMthFromLast {

    @Test
    public void testLarge_P1() {
        //
        LinkedList input = new LinkedList();
        for(int i=0;i<10000;i++) input.add(i);

        int M=1000;
        IGetMthFromLast solver = new GetMthFromLastV1();

        long startTime = System.nanoTime();
        Integer answer = solver.getMthFromLast(input,M);
        long endTime = System.nanoTime();
        System.out.println(M+"# "+(answer==null?"NIL":answer)+" took "+(endTime-startTime)/1000);
        assertEquals(9000,answer);
    }
    @Test
    public void testLarge_P2() {
        //
        LinkedList input = new LinkedList();
        for(int i=0;i<10000;i++) input.add(i);

        int M=9000;
        IGetMthFromLast solver = new GetMthFromLastV1();

        long startTime = System.nanoTime();
        Integer answer = solver.getMthFromLast(input,M);
        long endTime = System.nanoTime();
        System.out.println(M+"# "+(answer==null?"NIL":answer)+" took "+(endTime-startTime)/1000);
        assertEquals(1000,answer);
    }
    @Test
    public void testLarge_Edge1() {
        //
        LinkedList input = new LinkedList();
        for(int i=0;i<10000;i++) input.add(i);

        int M=1;
        IGetMthFromLast solver = new GetMthFromLastV1();

        long startTime = System.nanoTime();
        Integer answer = solver.getMthFromLast(input,M);
        long endTime = System.nanoTime();
        System.out.println(M+"# "+(answer==null?"NIL":answer)+" took "+(endTime-startTime)/1000);
        assertEquals(9999,answer);
    }
    @Test
    public void testLarge_Edge2() {
        //
        LinkedList input = new LinkedList();
        for(int i=0;i<10000;i++) input.add(i);

        int M=10000;
        IGetMthFromLast solver = new GetMthFromLastV1();

        long startTime = System.nanoTime();
        Integer answer = solver.getMthFromLast(input,M);
        long endTime = System.nanoTime();
        System.out.println(M+"# "+(answer==null?"NIL":answer)+" took "+(endTime-startTime)/1000);
        assertEquals(0,answer);
    }

    @Test
    public void testXLarge_P1() {
        //
        LinkedList input = new LinkedList();
        for(int i=0;i<1000000;i++) input.add(i);

        int M=100000;
        IGetMthFromLast solver = new GetMthFromLastV1();

        long startTime = System.nanoTime();
        Integer answer = solver.getMthFromLast(input,M);
        long endTime = System.nanoTime();
        System.out.println(M+"# "+(answer==null?"NIL":answer)+" took "+(endTime-startTime)/1000);
        assertEquals(900000,answer);
    }

}
