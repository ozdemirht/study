package solution;

import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Deque;

public class QueueByTwoStack<T> implements IQueue<T> {
    private Deque<T> stack1 = new ArrayDeque<>();
    private Deque<T> stack2 = new ArrayDeque<>();

    private int size = 0;

    public QueueByTwoStack() {
    }

    @Override
    public void enqueue(T value) {
        stack1.push(value);
        size++;
        //print(stack1,System.out);
    }

    @Override
    public T dequeue() {
        if (size() < 1) return null;
        // copy stack1 into stack2
        if(stack2.isEmpty()) swapAndReverseStacks(stack1, stack2);
        // remove the top of stack2
        T tos = stack2.pop();
        // copy stack2 to stack1
        //swapAndReverseStacks(stack2, stack1);
        //print(stack1,System.out);
        // update number of elements
        size--;
        return tos;
    }

    @Override
    public T peek() {
        if (size() < 1) return null;
        if(stack2.isEmpty()) swapAndReverseStacks(stack1, stack2);
        T tos = stack2.peek();
        //swapAndReverseStacks(stack2, stack1);
        //print(stack1,System.out);
        return tos;
    }

    @Override
    public int size() {
        return size;
    }

    private void swapAndReverseStacks(Deque<T> stack1, Deque<T> stack2) {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
    }

    private void print(Deque<T> aStack, PrintStream out) {
        out.println();
        aStack.stream().forEach(x -> out.print(x + ","));
        out.println();
    }
}

