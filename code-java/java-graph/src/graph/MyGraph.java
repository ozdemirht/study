package graph;

import com.sun.istack.internal.NotNull;

import java.io.PrintStream;
import java.util.*;

public class MyGraph<T extends Comparable<T>> {
    ArrayList<GraphNode<T>> nodes = new ArrayList<>();

    public MyGraph() {

    }
    public GraphNode<T> getFirstNode(){
        return (nodes.size()>0?nodes.get(0):null);
    }
    public void addNode(@NotNull GraphNode<T> aNode) {
        nodes.add(aNode);
    }

    public void addNodeEdges(@NotNull GraphNode<T> aNode, @NotNull GraphNode<T>[] edges) {
        aNode.addEdges(edges);
    }

    public void print(PrintStream pout) {
        for (GraphNode<T> aNode : nodes)
            aNode.print(pout);
    }

    private void DFS(Set<GraphNode<T>> visited, GraphNode<T> current, StringBuffer order) {
        for (GraphNode<T> next : current.edges)
            if (!visited.contains(next)) {
                visited.add(next);
                order.append(next.getData());
                DFS(visited, next, order);
            }
    }

    public void DFS(StringBuffer order) {
        Set<GraphNode<T>> visited = new HashSet<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (!visited.contains(nodes.get(i))) {
                visited.add(nodes.get(i));
                order.append(nodes.get(i).getData());
                DFS(visited, nodes.get(i), order);
            }
        }
    }

    public int findNumberOfConnectedComponents() {
        Set<GraphNode<T>> visited = new HashSet<>();
        StringBuffer order = new StringBuffer();
        int count = 0;
        for (int i = 0; i < nodes.size(); i++) {
            if (!visited.contains(nodes.get(i))) {
                count++;
                visited.add(nodes.get(i));
                order.append(nodes.get(i).getData());
                DFS(visited, nodes.get(i), order);
            }
        }
        return count;
    }
    private void BFS(GraphNode<T> start, Set<GraphNode<T>> visited, StringBuffer order) {
        Deque<GraphNode<T>> nodeQueue = new ArrayDeque<>();
        nodeQueue.addLast(start);

        while (nodeQueue.size()>0){
            GraphNode<T> current = nodeQueue.removeFirst();
            visited.add(current);
            order.append(current.getData());

            for(GraphNode<T> nxt: current.edges)
                if(!visited.contains(nxt))
                    nodeQueue.addLast(nxt);
        }
    }
    public void BFS(GraphNode<T> start, StringBuffer order) {
        if(!nodes.contains(start)) return;
        Set<GraphNode<T>> visited = new HashSet<>();
        BFS(start,visited,order);
    }

    public int findNumberOfConnectedComponentsByBFS() {
        Set<GraphNode<T>> visited = new HashSet<>();
        StringBuffer order = new StringBuffer();
        int count = 0;
        for (int i = 0; i < nodes.size(); i++) {
            if (!visited.contains(nodes.get(i))) {
                count++;
                BFS(nodes.get(i), visited, order);
            }
        }
        return count;
    }

}
