import com.sun.istack.internal.NotNull;

import java.io.PrintStream;
import java.util.ArrayList;

public class MyGraph<T extends Comparable<T>> {
    ArrayList<GraphNode<T>> nodes = new ArrayList<>();
    MyGraph(){

    }
    public void addNode(@NotNull GraphNode<T> aNode){
        nodes.add(aNode);
    }
    public void addNodeEdges(@NotNull GraphNode<T> aNode, @NotNull GraphNode<T>[] edges){
        aNode.addEdges(edges);
    }
    public void print(PrintStream pout){
        for(GraphNode<T> aNode: nodes)
            aNode.print(pout);
    }
}
