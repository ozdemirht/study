public class ReverseString {

    public static  String reverseString(String input){
        if(input==null || input.length()<1)
            return "";
        return reverseString(input.substring(1))+input.charAt(0);
    }
    public static void main(String[] args) {

        String test1 = "abcdefg1rd3";
        System.out.println("\nreverse("+test1+")=["+reverseString(test1)+"]");
    }
}
