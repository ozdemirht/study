package solver;

import java.util.*;

public class Result implements ISolver {

    Integer findMedian(List<Integer> arr, int length) {
        Integer pivot = arr.get(arr.size()/2);
        List<Integer> lessThan = new ArrayList<Integer>();
        List<Integer> theSame = new ArrayList<Integer>();
        List<Integer> moreThan = new ArrayList<Integer>();
        //System.out.println("findMedian("+arr.size()+","+length+")");
        for(Integer v : arr){
            if( v.intValue()<pivot.intValue()){
                lessThan.add(v);
            } else if(v.intValue()>pivot.intValue()){
                moreThan.add(v);
            } else
                theSame.add(v);
        }
        //System.out.println("lessThan.size()="+lessThan.size());
        //System.out.println("theSame.size()="+theSame.size());
        //System.out.println("moreThan.size()="+moreThan.size());
        if(lessThan.size()>length){
            return findMedian(lessThan,length);
        } else if((lessThan.size()+theSame.size())>=length){
            return theSame.get(0);
        } else {
            //System.out.println("length="+length+" new_length="+(length-(lessThan.size()+theSame.size())));
            return findMedian(moreThan,length-(lessThan.size()+theSame.size()));
        }

    }
    @Override
    public Integer solve(List<Integer> arr){
        Integer median = findMedian(arr, (int) Math.floor(arr.size()/2));
        System.out.println("Median="+median);
        return median;
    }
}
