import com.sun.istack.internal.NotNull;

import java.io.PrintStream;

public class MyList<T> {
    ListNode<T> head ;

    public MyList() {
        head = null;
    }

    public void add(@NotNull ListNode<T> element) {
        if (head != null)
            element.setNext(head);
        head = element;
        //System.out.println("add(): "); print(System.out);
    }

    public void print(@NotNull PrintStream pout) {
        pout.print("[");
        ListNode<T> next = head;
        while (next != null) {
            pout.print(next.getData() + " ");
            next = next.getNext();
        }
        pout.print("]");
    }

    public ListNode<T> getHead() {
        return head;
    }

    public MyList<T> clone() throws CloneNotSupportedException {
        super.clone();
        MyList<T> answer = new MyList<>();
        ListNode<T> next = head;
        while (next != null) {
            answer.add(next.clone());
            next = next.getNext();
        }
        return answer;
    }

    public MyList<T> reversed() throws Exception {
        MyList<T> answer = new MyList<>();
        reversed(head, answer);
        return answer;
    }

    private void reversed(ListNode<T> head, MyList<T> answer) throws Exception {
        if (head == null)
            return;
        answer.add(head.clone());
        if (head.getNext() != null)
            reversed(head.getNext(), answer);
    }

}
