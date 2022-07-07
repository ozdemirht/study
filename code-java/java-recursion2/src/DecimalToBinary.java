public class DecimalToBinary {
    public static String findBinary(int decimal, String answer){
        if(decimal==0)
            return answer;
        answer = decimal % 2 + answer;
        return findBinary( decimal / 2, answer);
    }

    public static String findBinary2(int decimal) {
        // call stack O(log n)
        return (decimal > 0 ? findBinary2(decimal / 2) + "" + (decimal % 2) : "");
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] testArray = {129, 255,1022};
        for (int test1 : testArray)
            System.out.println("isPalindrome(" + test1 + ")=[" + findBinary(test1,"") + "] " + findBinary2(test1));
    }
}
