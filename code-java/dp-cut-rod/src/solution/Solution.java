package solution;

public class Solution implements ISolution {

    @Override
    public float findMaxRevenueByCuts(int lengthOfRawRod, StandardRods[] input) {
        if (lengthOfRawRod < input[0].getLength())
            return 0;
        float revenue = Float.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            // enough to make a cut
            if (lengthOfRawRod >= input[i].getLength()) {
                //System.out.println(lengthOfRawRod+" "+input[i].getLength()+" "+input[i].getPrice());
                float rev_i = input[i].getPrice()
                        + findMaxRevenueByCuts(lengthOfRawRod - input[i].getLength(), input);
                revenue = Math.max(revenue, rev_i);
            } else break;
        }
        return revenue;
    }

}
