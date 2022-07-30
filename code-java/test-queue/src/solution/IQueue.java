package solution;

public interface IQueue<T> {
    public void enqueue(T val);

    public T dequeue() ;

    public T peek() ;

    public int size();
}
