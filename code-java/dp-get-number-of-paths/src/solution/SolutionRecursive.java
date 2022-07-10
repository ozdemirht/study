package solution;

import java.util.Arrays;

public class SolutionRecursive implements ISolution {

    @Override
    public int solve(int m, int n){
        if(m==1 && n==1 ) return 1;
        if(m==0 || n==0 ) return 0;
        return solve(m-1,n)+solve(m,n-1);
    }
}
