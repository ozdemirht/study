public class Main {
    public static void main(String[] args) {

        MyBST<Integer> test = new MyBST<>();
        int i;
        for(i=0;i<10;i++)
            test.insert((int)(113*Math.random()));
        test.print(System.out);
        test.printInOrder(System.out);
        System.out.print("\nLeaf nodes: ");
        test.printAllLeafNodes(System.out);
        System.out.print("\nPost order: ");
        test.printPostOrder(System.out);
        System.out.print("\nPre order: ");
        test.printPreOrder(System.out);
    }
}