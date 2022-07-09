public class Main {
    public static void main(String[] args) {
        String[] tests = new String[]{"()","((((", "(()(())())", "())",
                                    "[]","{}","[{}]","[{()}]",
                                    "[}","[)","(}","(]",
                                    "{)","{]","[()]","[({})]"};
        int[] expected = new int[]{ 1,0,1,0,
                                    1,1,1,1,
                                    0,0,0,0,
                                    0,0,1,1};
        ISolution solver = new Solution();
        for(int i=0;i<tests.length;i++) {
            System.out.println("Input=|" + tests[i]
                    + "| " + solver.solution(tests[i])
                    + " isPassed?="+(solver.solution(tests[i])==expected[i]));
        }

    }
}