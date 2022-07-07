public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyGraph<Integer> myTest = new MyGraph<>();

        GraphNode<Integer>[] nodes = new GraphNode[]{new GraphNode<>(1), new GraphNode<>(2),
                new GraphNode<>(3), new GraphNode<>(4)};
        for(GraphNode<Integer> a: nodes) myTest.addNode(a);
        myTest.print(System.out);
        myTest.addNodeEdges(nodes[0],new GraphNode[]{nodes[1]});
        myTest.print(System.out);
    }
}