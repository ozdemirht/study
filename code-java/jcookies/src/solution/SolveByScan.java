package solution;

import java.util.List;

public class SolveByScan implements ICookies {

    @Override
    public int cookies(int k, List<Integer> A){
        // Write your code here
        int answer = -1;
        int numberOfOperations = 0;
        int i;
        int minA1Value=-1, minA1Index;
        int minA2Value=-1, minA2Index;

        do
        {
            if(A.size()<2) {

                if(A.size()>0 && A.get(0)>k)
                    answer=0;
                break;
            }
            if(A.get(0)<A.get(1)){
                minA1Index = 0;
                minA2Index = 1;
            } else {
                minA1Index = 1;
                minA2Index = 0;
            }
            minA1Value = A.get(minA1Index);
            minA2Value = A.get(minA2Index);
            for(i=2;i<A.size();i++) {
                if(A.get(i)<A.get(minA1Index)) {
                    minA2Index = minA1Index;
                    minA1Index = i;
                    minA1Value = A.get(minA1Index);
                    minA2Value = A.get(minA2Index);
                } else if(A.get(i)<A.get(minA2Index)) {
                    minA2Index = i;
                    minA2Value = A.get(minA2Index);
                }
            }
            //System.err.println("size=["+A.size()+"] k=["+k+"] minA1Value=["+minA1Value+"] numberOfOperations=["+numberOfOperations+"]");
            if(minA1Value<k) {
                A.remove(Math.max(minA1Index,minA2Index));
                A.remove(Math.min(minA1Index,minA2Index));
                A.add(minA1Value+2*minA2Value);
                numberOfOperations++;

                //System.err.println("size=["+A.size()+"] k=["+k+"] minA1Value=["+minA1Value+"] numberOfOperations=["+numberOfOperations+"]");

                // O(n) Find new min
                minA1Index = 0;
                for(i=1;i<A.size();i++)
                    if(A.get(i)<A.get(minA1Index))
                        minA1Index=i;
                // Update answer
                if(A.get(minA1Index)>=k)
                    answer = numberOfOperations;
            } else
                answer = numberOfOperations;
        } while(A.get(minA1Index)<k);

        return answer;
    }
}
