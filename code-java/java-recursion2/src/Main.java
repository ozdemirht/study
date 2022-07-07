import com.sun.deploy.security.SelectableSecurityManager;
import com.sun.istack.internal.NotNull;

public class Main {
    static ListNodeHelper helper = new ListNodeHelper();
    static ListNode<Integer> test = new ListNode<>(-1);

    public static <T> void printList(@NotNull ListNode<T> list){
        ListNode<T> current = list;
        System.out.println();
        do{
            System.out.print(current.getData()+" ");
            current = current.getNext();
        } while( current!=null );
        System.out.println();
    }
    public static <T> ListNode<T> reverseLinkedList(@NotNull ListNode<T> list) throws Exception {
        if(list.getNext()==null)
            return list.clone();
        ListNode<T> p = reverseLinkedList(list.getNext()).clone();
        list.next.next = list;
        list.next = null;
        return p;
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Hello world!");

        MyList<Integer> t = new MyList<>();
        MyList<Integer> t2 = new MyList<>();

        helper.buildLinkedList2(6,t2);
        t2.print(System.out);
        MyList<Integer> reversed_t2 = t2.reversed();
        reversed_t2.print(System.out);

        helper.buildLinkedList2(4,t);
        t.print(System.out);
        t.reversed().print(System.out);

        MyList<Integer> t3 = new MyList<>();
        helper.buildLinkedList2(5,t3);

        System.out.print("\nFirst list: ");
        t.print(System.out);

        System.out.print("\nSecond list: ");
        t3.print(System.out);

        System.out.print("\nmerged list: ");
        MyList<Integer> merged = helper.mergeLinkedList(t,t3);
        merged.print(System.out);

        System.out.print("\nreversed merged list: ");
        merged.reversed().print(System.out);

    }

}