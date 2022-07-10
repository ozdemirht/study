package solution;

import java.util.Arrays;


public class SolutionTabularFromBottom implements ISolution {
    @Override
    public float findMaxRevenueByCuts(int lengthOfRawRod, StandardRods[] input) {
        float[] revenue = new float[lengthOfRawRod + 1];
        Arrays.fill(revenue, 0);
        for (int i = 0; i < revenue.length; i++) {
            for (int j = 0; j < input.length; j++) {
                int next = i + input[j].getLength();
                if (next <= lengthOfRawRod) { // we can make a cut
                    if ((revenue[i] + input[j].getPrice()) > revenue[next]) // we can produce better revenue
                        revenue[next] = revenue[i] + input[j].getPrice();
                }
            }
        }
        // Time Complexity : O(n*m) where n=length(lengthOfRawRod) and m=input.length
        // Space Complexity : O(n) due to revenue[]
        return revenue[lengthOfRawRod];
    }
}
