public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Solution solver = new Solution();
        int[] test = new int[] { 9, 529, 20, 15, 1041, 32};
        int[] expected = new int[] { 2, 4, 1, 0, 5, 0};
        for(int i=0;i<test.length;i++)
            System.out.println("test["+i+"]=("+test[i]+
                                ") bin=["+Integer.toBinaryString(test[i])+
                                "] answer="+solver.solution(test[i])+
                                " passed="+(solver.solution(test[i])==expected[i])
                                );

    }
}