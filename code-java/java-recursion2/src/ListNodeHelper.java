import com.sun.istack.internal.NotNull;

public class ListNodeHelper {
    public void buildLinkedList(int n, @NotNull ListNode<Integer> list) {
        for (int i = 0; i < n; i++) {
            ListNode<Integer> newNode = new ListNode<>(i);
            if (list.getNext() != null) {
                ListNode<Integer> next = list.getNext();
                newNode.setNext(next);
            }
            list.setNext(newNode);
        }
        //return list;
    }

    public void buildLinkedList2(int n, @NotNull MyList<Integer> list) {
        for (int i = 0; i < n; i++)
            list.add(new ListNode<>((int) (i * Math.random() * 100)));
    }

    public <T> ListNode<T> reverseLinkedList(@NotNull ListNode<T> list) {
        if (list.getNext() == null)
            return list;
        ListNode<T> p = reverseLinkedList(list.getNext());
        list.next.next = list;
        list.next = null;
        return p;
    }

    public <T extends Comparable<T>> MyList<T> mergeLinkedList(@NotNull MyList<T> list1, @NotNull MyList<T> list2) throws CloneNotSupportedException {
        MyList<T> answer = new MyList<>();
        ListNode<T> nextList1 = list1.getHead();
        ListNode<T> nextList2 = list2.getHead();
        while (nextList1 != null && nextList2 != null) {
            if (nextList1.getData().compareTo(nextList2.getData()) < 0) {
                answer.add(nextList1.clone());
                nextList1 = nextList1.getNext();
            } else if (nextList1.getData().compareTo(nextList2.getData()) > 0) {
                answer.add(nextList2.clone());
                nextList2 = nextList2.getNext();
            } else {
                answer.add(nextList1.clone());
                nextList1 = nextList1.getNext();
                answer.add(nextList2.clone());
                nextList2 = nextList2.getNext();
            }
        }
        while (nextList1 != null) {
            answer.add(nextList1.clone());
            nextList1 = nextList1.getNext();
        }
        while (nextList2 != null) {
            answer.add(nextList2.clone());
            nextList2 = nextList2.getNext();
        }
        return answer;
    }
}
