import java.util.*;

public class Solution implements ISolution {

    final boolean isClosing(char c){
        return (c==')'||c==']'||c=='}');
    }
    final boolean isMatching(char c, char tos){
        boolean answer = false;
        switch(c){
            case ')': answer= (tos=='('); break;
            case ']': answer= (tos=='['); break;
            case '}': answer= (tos=='{'); break;
            default: answer=false;
        }
        return answer;
    }
    @Override
    public int solution(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i< input.length();i++){
            char c = input.charAt(i);
            if( isClosing(c) && stack.size()>0) {
                if (isMatching(c,stack.peek())) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
            //stack.stream().forEach(x->System.out.print(x+","));System.out.println();
        }
        return (stack.size()==0?1:0);
    }
}
