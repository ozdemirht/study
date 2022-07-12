package solution;

import java.util.HashMap;
import java.util.Map;

public class SolutionToCanConstructMemo implements ICanConstructSolution {

    @Override
    public boolean canConstruct(String targetWord, String[] wordBank){
        Map<String,Boolean> memo = new HashMap<>();
        return canConstruct(targetWord, wordBank, memo);
    }
    public boolean canConstruct(String targetWord, String[] wordBank,Map<String, Boolean> memo){
        // base
        //System.out.println("targetWord:["+targetWord+"]");
        if(targetWord==null || targetWord.length()<1)
            return true;
        if(memo.containsKey(targetWord))
            return memo.get(targetWord);
        boolean answer=false;
        for(int i=0; !answer && i<wordBank.length;i++){
            if(targetWord.startsWith(wordBank[i]))
                answer = canConstruct(targetWord.substring(wordBank[i].length()),wordBank,memo);
        }
        memo.put(targetWord,answer);
        return answer;
    }
}
