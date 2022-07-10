package solution;

import java.util.HashMap;
import java.util.Map;

public class SolutionMemo implements ISolution {
    @Override
    public int solve(int m, int n){
        Map<String, Integer> memo = new HashMap<>();
        return solve(m,n,memo);
    }
    int solve(int m, int n, Map<String,Integer> memo){
        if(m==1 && n==1 ) return 1;
        if(m==0 || n==0 ) return 0;

        String memoKey = ""+m+"_"+n;
        if(memo.containsKey(memoKey)) return memo.get(memoKey);

        int answer = solve(m-1,n)+solve(m,n-1);
        memo.put(memoKey,answer);
        String memoKey2 = ""+n+"_"+m;
        memo.put(memoKey2,answer);
        return answer;
    }

}
