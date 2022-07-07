/**
 * Reverse to Make Equal
Given two arrays A and B of length N,
 determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.

 Signature
    bool areTheyEqual(int[] arr_a, int[] arr_b)

 Input
    All integers in array are in the range [0, 1,000,000,000].

 Output
    Return true if B can be made equal to A, return false otherwise.

 Example
    A = [1, 2, 3, 4]
    B = [1, 4, 3, 2]
    output = true
    After reversing the subarray of B from indices 1 to 3, array B will equal array A.
 * */
public class Main {
    // Add any helper functions you may need here

    boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
        int i,j,k;
        boolean found = true;
        for (i=0;found && i<array_a.length;i++) {
            if (array_a[i] != array_b[i]) {
                found = false;
                j = i ;
                while(!found && j < array_b.length)
                    if (array_a[i] == array_b[j]) {
                        found = true;
                    } else j++;

                if (found) {
                    //System.out.println("j="+j+" i="+i);
                    int[] tmp = new int[j - i+1];
                    for (k = 0; k < (j - i+1); k++)
                        tmp[k] = array_b[j - k];
                    for (k = 0; k < (j - i+1); k++)
                        array_b[i + k] = tmp[k];
                    //for(k=0;k<array_b.length;k++)
                    //   System.out.print(array_b[k]+" ");
                    //System.out.println();
                }
            }
        }
        return found;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    public void run() {
        int[] array_a_1 = {1, 2, 3, 4};
        int[] array_b_1 = {1, 4, 3, 2};
        boolean expected_1 = true;
        boolean output_1 = areTheyEqual(array_a_1, array_b_1);
        check(expected_1, output_1);

        int[] array_a_2 = {1, 2, 3, 4};
        int[] array_b_2 = {1, 4, 3, 3};
        boolean expected_2 = false;
        boolean output_2 = areTheyEqual(array_a_2, array_b_2);
        check(expected_2, output_2);
        // Add your own test cases here

        int[] array_a_3 = {1, 2, 3, 4, 5, 6, 7};
        int[] array_b_3 = {1, 4, 3, 2, 5, 7, 6};
        boolean expected_3 = true;
        boolean output_3 = areTheyEqual(array_a_3, array_b_3);
        check(expected_3, output_3);

    }

    public static void main(String[] args) {
        new Main().run();
    }
    public static void main2(String[] args) {
        System.out.println("Hello world!");
    }
}