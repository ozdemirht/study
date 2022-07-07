public class Palindrome {

    /*
    Let length(input) be N
    Time Complexity : O(N)
    Space Complexity : (call stack), O(N) [actually N/2 frames; PC and input parameter]
     */
    public static boolean isPalindrome(String input){
        if(input==null || input.length()<2)
            return true;
        if(input.charAt(0)!=input.charAt(input.length()-1))
            return false;
        return isPalindrome(input.substring(1,input.length()-1));
    }

    /*
    Iterative, to avoid call stack
    Let length(input) be N
    Time Complexity : O(N) [due to while loop]
    Space Complexity : O(N) [local, ]
    The previous solution and this solution both uses substring() to
    allocate new memory for shortened input.
     */
    public static boolean isPalindromeIterative(String input) {
        if (input == null || input.length() < 2)
            return true;
        String local = input;
        while (local.length() > 1 &&
                local.charAt(0) == local.charAt(local.length() - 1))
            local = local.substring(1, local.length() - 1);
        return (local.length() < 2);
    }

    /*
    It is possible to reach O(1) Space complexity
     */
    public static boolean isPalindromeIterative2(String input) {
        if (input == null || input.length() < 2)
            return true;
        int i=0, half = input.length() / 2;
        while (i < half &&
                input.charAt(i) == input.charAt(input.length() - 1 - i))
            i++;
        return (i >= half);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] testArray = {"abcdefg1rd3", "kayak", "racecar"};
        for (String test1 : testArray)
            System.out.println("isPalindrome(" + test1 + ")=[" + isPalindrome(test1) + "]"
                    + " [1] " + isPalindromeIterative(test1)
                    + " [2] " + isPalindromeIterative2(test1));
    }
}
