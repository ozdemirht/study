import solution.*;

public class Main {
    public static void main(String[] args) {

        StandardRods[] sellable = new StandardRods[] { new StandardRods(1,1),
                                                        new StandardRods(2,3),
                                                        new StandardRods(4,4),
                                                        new StandardRods(5,6)
                                                    };

        ISolution solver = new Solution();
        float revenue;
        revenue=solver.findMaxRevenueByCuts(5,sellable);
        System.out.format("\nRevenue from rod("+5+") is %.3f",revenue);

        solver = new SolutionMemo();
        revenue=solver.findMaxRevenueByCuts(5,sellable);
        System.out.format("\nRevenue from rod("+5+") is %.3f",revenue);

        solver = new SolutionTabularFromBottom();
        revenue=solver.findMaxRevenueByCuts(5,sellable);
        System.out.format("\nRevenue from rod("+5+") is %.3f",revenue);

    }
}