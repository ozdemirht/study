package solution;

public class QueueBySinglyList<T> implements IQueue<T> {
    private SinglyListNode<T> head;
    private SinglyListNode<T> tail;
    private int size = 0;

    public QueueBySinglyList() {
        head = null;
        tail = null;
    }

    @Override
    public void enqueue(T value) {
        SinglyListNode<T> newElement = new SinglyListNode<>(value, head);
        head = newElement;
        if (tail == null) tail = newElement;
        size++;
    }

    @Override
    public T dequeue() {
        if (size() < 1) return null;
        SinglyListNode<T> priorOfTail = head;
        T returnValue;
        // O(n)
        while (priorOfTail != null && priorOfTail != tail && priorOfTail.getNext() != tail)
            priorOfTail = priorOfTail.getNext();
        returnValue = tail.getValue();
        if (tail == head) {
            tail = null;
            head = null;
        } else {
            tail = priorOfTail;
            tail.setNext(null);
        }
        size--;
        return returnValue;
    }

    @Override
    public T peek() {
        return (tail != null ? tail.getValue() : null);
    }

    @Override
    public int size() {
        return size;
    }
}
