package solution;

import java.util.Arrays;

public class SolutionTabular implements ISolution {

    @Override
    public int solve(int m, int n){
        int i, j, answer=0;
        int[][] board= new int[m+1][n+1];
        for(i=0;i<=m;i++) {
            Arrays.fill(board[i],0);
        }
        // starts (1,1) and ends (m,n)
        // paths[1][1]=1;
        // paths[1][1]->path[1][2]
        // number of paths to path[i][j]=path[i-1][j]+path[i][j-1] if possible
        for(i=0;i<=n;i++) board[0][i]=0;
        for(i=0;i<=m;i++) board[i][0]=0;
        board[0][1]=1;
        for(i=1;i<=m;i++)
            for(j=1;j<=n;j++){
                board[i][j]=board[i-1][j]+board[i][j-1];
            }
        return board[m][n];
    }
}
