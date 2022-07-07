import java.util.Arrays;

public class Main {
    public static void merge(int[] data, int start, int mid, int end) {
        // there are two sorted sub arrays, (start,mid) and (mid+1,end)
        int[] temp = new int[end - start + 1];
        int fs = start, ss = mid + 1, ti = 0;
        // until one is exhausted
        while (fs <= mid && ss <= end) {
            if (data[fs] <= data[ss]) {
                temp[ti] = data[fs];
                fs++;
            } else {
                temp[ti] = data[ss];
                ss++;
            }
            ti++;
        }
        // copy left array
        while (fs <= mid) {
            temp[ti] = data[fs];
            fs++;
            ti++;
        }
        // copy right array
        while (ss <= end) {
            temp[ti] = data[ss];
            ss++;
            ti++;
        }
        // copy temp into data
        for (ti = start; ti <= end; ti++)
            data[ti] = temp[ti - start];
    }
    public static void mergeSort(int[] data,int start, int end){
        if( start<end){
            int mid = (start + end) /2;
            mergeSort(data,start, mid);
            mergeSort(data,mid+1, end);
            merge(data,start, mid, end);
        }
    }
    public static void mergeSort(int[] data){
        mergeSort(data,0, data.length-1);
    }
    public static void main(String[] args) {
        int i;
        int[] testData = new int[10];
        for(i=0;i<testData.length;i++) testData[i]=(int) (111*Math.random());
        System.out.println("\nBefore mergesort\n");
        Arrays.stream(testData).forEach(x->System.out.print(x+" "));
        mergeSort(testData);
        System.out.println("\nAfter mergesort\n");
        Arrays.stream(testData).forEach(x->System.out.print(x+" "));
    }
}