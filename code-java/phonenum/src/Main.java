import phonenum.Solution;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> answer = new ArrayList<>();
        Solution solver = new Solution();

        answer = new ArrayList<>();
        solver.solve("111",answer);
        System.out.print("\nInput:"+"111\nOutput:");
        answer.stream().forEach(x->System.out.print(x+" "));

        answer = new ArrayList<>();
        solver.solve("112",answer);
        System.out.print("\nInput:"+"112\nOutput:");
        answer.stream().forEach(x->System.out.print(x+" "));

        answer = new ArrayList<>();
        solver.solve("119",answer);
        System.out.print("\nInput:"+"119\nOutput:");
        answer.stream().forEach(x->System.out.print(x+" "));

        answer = new ArrayList<>();
        solver.solve("129345",answer);
        System.out.print("\nInput:"+"129345\nOutput:\n"+answer.size());
        //answer.stream().forEach(x->System.out.println(x));
    }
}