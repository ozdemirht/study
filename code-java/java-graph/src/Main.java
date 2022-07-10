import graph.GraphNode;
import graph.MyGraph;

public class Main {
    public static void main(String[] args) {

        MyGraph<Integer> myTest = new MyGraph<>();

        GraphNode<Integer>[] nodes = new GraphNode[]{new GraphNode<>(1), new GraphNode<>(2),
                new GraphNode<>(3), new GraphNode<>(4)};
        for(GraphNode<Integer> a: nodes) myTest.addNode(a);
        myTest.print(System.out);
        myTest.addNodeEdges(nodes[0],new GraphNode[]{nodes[2],nodes[1]});
        myTest.addNodeEdges(nodes[2],new GraphNode[]{nodes[3]});
        myTest.print(System.out);

        StringBuffer order = new StringBuffer();
        myTest.DFS(order);
        System.out.println("DFS: "+order.toString());

        order = new StringBuffer();
        myTest.BFS(nodes[0],order);
        System.out.println("BFS: "+order.toString());

        System.out.println("Number of connected components="+myTest.findNumberOfConnectedComponents());
        System.out.println("Number of connected components="+myTest.findNumberOfConnectedComponentsByBFS());

        myTest = new MyGraph<>();
        nodes = new GraphNode[]{new GraphNode<>(1), new GraphNode<>(2),
                new GraphNode<>(3), new GraphNode<>(4)};
        for(GraphNode<Integer> a: nodes) myTest.addNode(a);
        myTest.addNodeEdges(nodes[0],new GraphNode[]{nodes[2]});
        myTest.addNodeEdges(nodes[2],new GraphNode[]{nodes[3]});
        myTest.print(System.out);
        order = new StringBuffer();
        myTest.DFS(order);
        System.out.println(order.toString());
        System.out.println("Number of connected components="+myTest.findNumberOfConnectedComponents());
        System.out.println("Number of connected components="+myTest.findNumberOfConnectedComponentsByBFS());

    }
}