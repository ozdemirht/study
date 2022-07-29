
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.Arrays;

public class Result {
    static int[][] tiles = {{1,1},{1,2},{1,3},{1,4}};

    private static void
    printBoard(int n,int m,int[] board,PrintStream out){
        out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) out.print(board[i*m+j]);
            out.println();
        }
    }
    private static int
    countLegoBlocks(int n,int m,int[] board,int[] max) {
        int i=0,j,k,h,w;
        int count=0;

        for(i=0;i<n*m;i++)
            if(board[i]==0) count++;

        printBoard(n,m,board,System.out);

        if(count==0) return 1;

        int[] tempBoard = new int[n*m];
        for(i=0;i<n*m;i++) tempBoard[i]=board[i];

        int found=0;
        // for each tile
        for(i=0;i<4;i++) {
            // for each position (j,k) on board
            for(j=0;j<n;j++)
                for(k=0;k<m;k++){
                    count=0;
                    // Check if tile fits
                    for(h=0;h<tiles[i][0]&&(h+j)<n;h++)
                        for(w=0;w<tiles[i][1]&&(w+k)<m;w++)
                            if(tempBoard[(j+h)*m+k+w]==0)
                                count++;
                    // tile[i] fits
                    if(count==(tiles[i][0]*tiles[i][1])) {
                        // update temp board
                        for(h=0;h<tiles[i][0]&&(h+j)<n;h++)
                            for(w=0;w<tiles[i][1]&&(w+k)<m;w++)
                                tempBoard[(j+h)*m+k+w]=1;
                        // recursive
                        if(countLegoBlocks(n,m,tempBoard,max)==1)
                            max[0]++;
                        // clean up
                        for(h=0;h<tiles[i][0]&&(h+j)<n;h++)
                            for(w=0;w<tiles[i][1]&&(w+k)<m;w++)
                                tempBoard[(j+h)*m+k+w]=0;

                    }

                }

        }
        return 0;
    }
    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int legoBlocks(int n, int m) {
        // Write your code here
        int[] board = new int[n*m];
        Arrays.fill(board,0);
        int[] max = new int[1];
        max[0] = 0;
        countLegoBlocks(n,m,board,max);
        return max[0];
    }

}
