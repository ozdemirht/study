package solution;

import solution.ICanConstructSolution;

public class SolutionToCanConstructRecursive implements ICanConstructSolution {

    @Override
    public boolean canConstruct(String targetWord, String[] wordBank){
        // base
        //System.out.println("targetWord:["+targetWord+"]");
        if(targetWord==null || targetWord.length()<1)
            return true;
        boolean answer=false;
        for(int i=0; !answer && i<wordBank.length;i++){
            if(targetWord.startsWith(wordBank[i]))
                answer = canConstruct(targetWord.substring(wordBank[i].length()),wordBank);
        }
        return answer;
    }
}
