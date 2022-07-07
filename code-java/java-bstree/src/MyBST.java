import com.sun.istack.internal.NotNull;

import java.io.PrintStream;

public class MyBST<T extends Comparable<T>> {
    TreeNode<T> root;

    MyBST(){

    }
    MyBST(T data){
        root = new TreeNode<>(data);
    }

    public void insert(@NotNull T data) {
        if (root == null)
            root = new TreeNode<>(data);
        else
            insert(root, data);
    }
    private void insert(@NotNull TreeNode<T> start, @NotNull T data) {
        if (data.compareTo(start.getData())<0) {
            if (start.getLeft() != null)
                insert(start.getLeft(), data);
            else
                start.setLeft(new TreeNode<>(data));
        } else {
            if(start.getRight()!=null)
                insert(start.getRight(), data);
            else
                start.setRight(new TreeNode<>(data));
        }
    }

    public boolean contains(@NotNull T query){
        return false;
    }

    public void print(PrintStream pout){
        if(root==null) {
            pout.println("{}");
            return;
        }
        pout.println("{"+root.getData()+"}");

    }
    public void printInOrder(PrintStream pout){
        if(root==null) {
            pout.println("{}");
            return;
        }
        printInOrder(pout,root);

    }
    private void printInOrder(PrintStream pout, @NotNull TreeNode<T> start){
        if(start==null) return;
        pout.print("{"+start.getData()+" [");
        printInOrder(pout,start.getLeft());
        pout.print(",");
        printInOrder(pout,start.getRight());
        pout.print("] }");
    }
    public void printPostOrder(PrintStream pout){
        if(root==null) {
            pout.println("{}");
            return;
        }
        printPostOrder(pout,root);

    }
    private void printPostOrder(PrintStream pout, @NotNull TreeNode<T> start){
        if(start==null) return;
        pout.print("{ [");
        printPostOrder(pout,start.getLeft());
        pout.print(",");
        printPostOrder(pout,start.getRight());
        pout.print("] "+start.getData()+"}");
    }
    /*
    Depth First Search on Binary Tree
     */
    public void printAllLeafNodes(PrintStream pout){
        if(root==null) {
            pout.println("{}");
            return;
        }
        printAllLeafNodes(pout,root);
    }

    private void printAllLeafNodes(PrintStream pout, @NotNull TreeNode<T> start) {
        if (start == null) return;
        if (start.getLeft() == null && start.getRight() == null)
            pout.print("(" + start.getData() + ")");
        else {
            printAllLeafNodes(pout, start.getLeft());
            printAllLeafNodes(pout, start.getRight());
        }
    }

}
