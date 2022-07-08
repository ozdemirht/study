public class Solution {

    public int solution(int N){
        int answer =0;
        String binRepresentation = Integer.toBinaryString(N);

        //System.out.println("binary("+N+")=["+binRepresentation+"]");
        int i=0, count, max=-1;
        while(i<binRepresentation.length()){
            while(i<binRepresentation.length() &&
                    binRepresentation.charAt(i)=='1') i++;
            if(i<binRepresentation.length()){
               count=1; i++;
               while(i<binRepresentation.length() &&
                       binRepresentation.charAt(i)=='0') {
                   i++;
                   count++;
               }
               if (i<binRepresentation.length()) {
                   max=Math.max(count,max);
                   answer=max;
               }
            }
        }
        return answer;
    }

}
