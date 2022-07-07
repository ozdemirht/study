public class RecursiveSum {

    public static long recursiveSum(int n){
        return (n<=1? n: (n+recursiveSum(n-1)));
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] testArray = {129, 255,1022};
        for (int test1 : testArray)
            System.out.println("recursiveSum(" + test1 + ")=[" + recursiveSum(test1) + "] ");
    }
}
