import solution.GetMthFromLastV1;
import solution.IGetMthFromLast;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[] test1 = new int[]{1,2,3,4,5,6,7,8,9,10};
        int i, M;
        LinkedList input = new LinkedList();
        for(i=0;i<test1.length;i++) input.add(test1[i]);
        //Integer answer = getMthFromLast(input,2);
        //System.out.println("2# "+answer);

        IGetMthFromLast solver= new GetMthFromLastV1();
        Integer answer = solver.getMthFromLast(input,2);
        System.out.println("\n2# "+answer);

        input = new LinkedList();
        for(i=0;i<test1.length;i++) input.add(test1[i]);
        //answer = getMthFromLast(input,1);
        answer = solver.getMthFromLast(input,1);
        System.out.println("\n1# "+answer);

        input = new LinkedList();
        for(i=0;i<test1.length;i++) input.add(test1[i]);
        M=20;
        answer = solver.getMthFromLast(input,M);
        System.out.println("\n"+M+"# "+(answer==null?"NIL":answer));

        input = new LinkedList();
        for(i=0;i<test1.length;i++) input.add(test1[i]);
        M=9;
        answer = solver.getMthFromLast(input,M);
        System.out.println("\n"+M+"# "+answer);

        input = new LinkedList();
        for(i=0;i<test1.length;i++) input.add(test1[i]);
        M=10;
        answer = solver.getMthFromLast(input,M);
        System.out.println("\n"+M+"# "+answer);

        input = new LinkedList();
        for(i=0;i<10000;i++) input.add(i);
        M=1000;
        long startTime = System.nanoTime();
        answer = solver.getMthFromLast(input,M);
        long endTime = System.nanoTime();
        System.out.println(M+"# "+(answer==null?"NIL":answer)+" took "+(endTime-startTime)/1000);

        input = new LinkedList();
        for(i=0;i<10000;i++) input.add(i);
        M=9000;
        startTime = System.nanoTime();
        answer = solver.getMthFromLast(input,M);
        endTime = System.nanoTime();
        System.out.println(M+"# "+(answer==null?"NIL":answer)+" took "+(endTime-startTime)/1000);


    }

}