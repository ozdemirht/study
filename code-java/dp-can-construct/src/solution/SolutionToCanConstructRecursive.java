package solution;

import solution.ICanConstructSolution;

public class SolutionToCanConstructRecursive implements ICanConstructSolution, ICountConstruct {

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
    @Override
    public int countConstruct(String targetWord, String[] wordBank){
        Integer[] counter = new Integer[]{new Integer(0)};
        countConstruct(targetWord,wordBank,counter);
        return counter[0].intValue();
    }
    private boolean countConstruct(String targetWord, String[] wordBank, Integer[] counter){
        // base
        if(targetWord==null || targetWord.length()<1)
            return true;
        boolean answer=false;
        for(int i=0; i<wordBank.length;i++){
            if(targetWord.startsWith(wordBank[i])) {
                answer = countConstruct(targetWord.substring(wordBank[i].length()), wordBank, counter);
                if(answer && targetWord.equals(wordBank[i]))
                    counter[0]=new Integer(counter[0].intValue()+1);
            }
        }
        return counter[0].intValue()>0;
    }
}
