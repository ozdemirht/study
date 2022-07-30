package solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueByDeque<T> implements IQueue<T>{
    Deque<T> aQueue = new ArrayDeque<>();

    public QueueByDeque(){

    }
    @Override
    public void enqueue(T val){
        aQueue.addFirst(val);
    }
    public T dequeue() {
        return aQueue.removeLast();
    }

    public T peek() {
        return aQueue.peekLast();
    }

    public int size() {
        return aQueue.size();
    }
}
