import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int[] numberOfPairs(int[] nums) {
        int[] output = new int[2];
        output[0]=0;
        output[1]=nums.length;
        int i=0,j;

        List<Integer> list = new ArrayList<Integer>(nums.length);
        for(int intValue: nums) list.add(intValue);

        while(i< list.size()){
            int currentValue = list.get(i);
            j=i+1;
            while(j< list.size() && list.get(j)!=currentValue) j++;
            if(j< list.size()) {
                list.remove(j);
                list.remove(i);
                output[1]-=2;
                output[0]++;
            } else i++;
        }
        return output;
    }
}
