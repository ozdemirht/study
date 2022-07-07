import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

 class testLambda {

    public static void filterOdds(@NotNull List<Integer> data){
        System.out.println();
        for(int i=0;i<data.size(); i++)
            if(data.get(i).intValue() % 2 == 0)
                System.out.print(data.get(i).intValue()+" ");
        System.out.println();
    }

    public static void filterOddsByLambda(@NotNull List<Integer> data){
        System.out.println("\n");
        data.stream()
                .filter(x-> x.intValue() % 2 == 0)
                .forEach(x-> System.out.print(x.intValue()+" "));
        System.out.println();
    }
}

public class Main {
    public static final int[] test = new int[10];

    public static List<Integer> prepareTestData(int limit){
        List<Integer> data = new ArrayList<>();
        for(int i=0;i<limit;i++)
            data.add(new Integer((int)(Math.random()*7*3*21)));
        return data;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Integer> test_1 = prepareTestData(10);
        System.out.print("Input =");
        test_1.stream().forEach(x-> System.out.print(x.intValue()+" "));
        System.out.println("");
        (new testLambda()).filterOdds(test_1);

        System.out.print("Sorted Input =");
        test_1.stream().sorted().forEach(x-> System.out.print(x.intValue()+" "));

        (new testLambda()).filterOddsByLambda(test_1);

    }
}