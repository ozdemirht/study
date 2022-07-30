package solution;

public class SinglyListNode<T> {
    T value;
    SinglyListNode<T> next=null;

    SinglyListNode(T value, SinglyListNode<T> next){
        this.value=value;
        this.next=next;
    }
    SinglyListNode(T value){
        this(value,null);
    }
    public T getValue() { return value; }
    public SinglyListNode<T> getNext() { return next; }
    public void setNext(SinglyListNode<T> next) { this.next=next;}
}
