package solution;

import java.util.LinkedList;

public class GetMthFromLastV1 implements IGetMthFromLast {

    @Override
    public Integer getMthFromLast(LinkedList input, int M){
        Integer answer = null;

        if(M>input.size()) return answer;
        int i, NthElement = -1;

        System.out.println("M=["+M+"] ");
        input.stream().limit(11).forEach(x->System.out.print(x+" "));

        if(M<(input.size()/2)) {
            for (i = M; input.size() > 0 && i >0; i--)
                NthElement = ((Integer) input.removeLast()).intValue();
            if (i == 0) answer = new Integer(NthElement);
        } else {
            M=input.size()-M+1;
            for (i = M; input.size() > 0 && i > 0; i--)
                NthElement = ((Integer) input.removeFirst()).intValue();
            if (i == 0) answer = new Integer(NthElement);
        }
        return answer;
    }

}
