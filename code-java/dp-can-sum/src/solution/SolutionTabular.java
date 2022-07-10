package solution;

import java.util.Arrays;

public class SolutionTabular implements ISolution {

    @Override
    public boolean canSum(int targetNum, int[] numbers) {
        int[] r = new int[targetNum+1]; // O(targetNum)
        Arrays.fill(r,0); // 0 means not reachable
        int i=0,j,next_i;

        for(j=0;j<numbers.length;j++){ // first states it can move
            next_i = i+numbers[j];
            if(next_i<=targetNum)
                r[next_i]++;
        }

        for(i=1;i<r.length && r[targetNum]==0;i++)
            if(r[i]>0) // next move should start from a visited state.
                for(j=0;j<numbers.length && r[targetNum]==0;j++){ // check all moves
                    next_i = i+numbers[j];
                    if(next_i<=targetNum)
                        r[next_i]++;
                }
        return r[targetNum]>0;
    }
}
