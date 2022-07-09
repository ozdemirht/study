import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class Solution implements ISolution {
    public int solution(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i< input.length();i++){
            char c = input.charAt(i);
            if(c==')' && stack.size()>0 && stack.peek()=='(') {
                   stack.pop();
                   continue;
            }
            stack.push(c);
            //stack.stream().forEach(x->System.out.print(x+","));System.out.println();
        }
        return (stack.size()==0?1:0);
    }

}
