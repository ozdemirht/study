public class Main {
    public static void main(String[] args) {
       
        String[] tests = new String[]{"()","((((", "(()(())())", "())"};
        ISolution solver = new Solution();
        for(int i=0;i<tests.length;i++) {
            System.out.println("Input=|" + tests[i] + "| " + solver.solution(tests[i]));
        }
    }
}
