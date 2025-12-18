package stackadt;

public interface MyStack<T> {
    void push(T item) throws StackOverflowException;
    T pop() throws StackUnderflowException;
    boolean isEmpty();
    boolean isFull();
    void display();
}
