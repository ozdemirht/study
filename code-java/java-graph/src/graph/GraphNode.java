package graph;

import com.sun.istack.internal.NotNull;

import java.io.PrintStream;
import java.util.ArrayList;

public class GraphNode< T extends Comparable<T>> {
    T data;
    ArrayList<GraphNode<T>> edges = new ArrayList<>();

    public GraphNode(T data){
        this.data=data;
    }

    public T getData() {
        return data;
    }

    public void addEdge(@NotNull GraphNode<T> next){
        if(next!=null) edges.add(next);
    }
    public void addEdges(@NotNull GraphNode<T>[] next){
        for(GraphNode<T> a: next) edges.add(a);
    }
    public void print(@NotNull PrintStream pout){
        pout.print("["+data+"]");
        for(GraphNode<T> next: edges) pout.print(next.getData()+" ");
        pout.println();
    }
}
