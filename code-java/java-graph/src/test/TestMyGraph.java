package test;

import graph.GraphNode;
import graph.MyGraph;
import org.junit.Test;
import org.testng.AssertJUnit;

public class TestMyGraph {

    MyGraph<Integer> setUpGraph1(){
        MyGraph<Integer> myTest = new MyGraph<>();

        GraphNode<Integer>[] nodes = new GraphNode[]{new GraphNode<>(1), new GraphNode<>(2),
                new GraphNode<>(3), new GraphNode<>(4)};
        for(GraphNode<Integer> a: nodes) myTest.addNode(a);
        myTest.addNodeEdges(nodes[0],new GraphNode[]{nodes[2],nodes[1]});
        myTest.addNodeEdges(nodes[2],new GraphNode[]{nodes[3]});
        return myTest;
    }

    MyGraph<Integer> setUpGraph2(){
        MyGraph<Integer> myTest = new MyGraph<>();

        GraphNode<Integer>[] nodes = new GraphNode[]{new GraphNode<>(1), new GraphNode<>(2),
                new GraphNode<>(3), new GraphNode<>(4)};
        for(GraphNode<Integer> a: nodes) myTest.addNode(a);
        myTest.addNodeEdges(nodes[0],new GraphNode[]{nodes[2]});
        myTest.addNodeEdges(nodes[2],new GraphNode[]{nodes[3]});
        return myTest;
    }

    @Test
    public void testFirst(){
        MyGraph<Integer> myTest = setUpGraph1();
        myTest.print(System.out);
    }
    @Test
    public void testDFS(){
        MyGraph<Integer> myTest = setUpGraph1();
        StringBuffer order = new StringBuffer();
        myTest.print(System.out);
        myTest.DFS(order);
        System.out.println("DFS: "+order.toString());
        AssertJUnit.assertEquals("1342",order.toString());
    }
    @Test
    public void testBFS(){
        MyGraph<Integer> myTest = setUpGraph1();
        StringBuffer order = new StringBuffer();
        myTest.print(System.out);
        myTest.BFS(myTest.getFirstNode(),order);
        System.out.println("BFS: "+order.toString());
        AssertJUnit.assertEquals("1324",order.toString());
    }

    @Test
    public void testFindNumberOfConnectedComponentsByDFS(){
        MyGraph<Integer> myTest = setUpGraph1();
        myTest.print(System.out);
        System.out.println("Number of connected components by DFS="+myTest.findNumberOfConnectedComponents());
        AssertJUnit.assertEquals(1,myTest.findNumberOfConnectedComponents());
    }

    @Test
    public void testFindNumberOfConnectedComponentsByDFS_2(){
        MyGraph<Integer> myTest = setUpGraph2();
        myTest.print(System.out);
        System.out.println("Number of connected components by DFS="+myTest.findNumberOfConnectedComponents());
        AssertJUnit.assertEquals(2,myTest.findNumberOfConnectedComponents());
    }

    @Test
    public void testFindNumberOfConnectedComponentsByBFS(){
        MyGraph<Integer> myTest = setUpGraph1();
        myTest.print(System.out);
        System.out.println("Number of connected components by BFS="+myTest.findNumberOfConnectedComponentsByBFS());
        AssertJUnit.assertEquals(1,myTest.findNumberOfConnectedComponentsByBFS());
    }
    @Test
    public void testFindNumberOfConnectedComponentsByBFS_2(){
        MyGraph<Integer> myTest = setUpGraph2();
        myTest.print(System.out);
        System.out.println("Number of connected components by BFS="+myTest.findNumberOfConnectedComponentsByBFS());
        AssertJUnit.assertEquals(2,myTest.findNumberOfConnectedComponentsByBFS());
    }
}
