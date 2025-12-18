package stackadt;

import java.util.Arrays;

class StackOverflowException extends Exception {
    public StackOverflowException(String message) {
        super(message);
    }
}

class StackUnderflowException extends Exception {
    public StackUnderflowException(String message) {
        super(message);
    }
}

public class StackArray<T> implements MyStack<T> {
    private Object[] stack;
    private int top;
    private int capacity;
    private final int MAX_CAPACITY = 100;

    public StackArray(int initialCapacity) {
        if (initialCapacity > MAX_CAPACITY) {
            throw new IllegalArgumentException("Initial capacity cannot exceed " + MAX_CAPACITY);
        }
        this.stack = new Object[initialCapacity];
        this.capacity = initialCapacity;
        this.top = -1;
    }

    @Override
    public void push(T item) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException("Cannot push: Stack reached maximum capacity (" + MAX_CAPACITY + ")");
        }
        if (top + 1 == capacity) {
            resize();
        }
        stack[++top] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Cannot pop from empty stack.");
        }
        T item = (T) stack[top];
        stack[top--] = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return capacity == MAX_CAPACITY && top + 1 == MAX_CAPACITY;
    }

    private void resize() {
        int newCapacity = Math.min(capacity * 2, MAX_CAPACITY);
        stack = Arrays.copyOf(stack, newCapacity);
        capacity = newCapacity;
        System.out.println("Stack resized to capacity: " + newCapacity);
    }

    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements (top to bottom): [ ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i]);
            if (i != 0) System.out.print(", ");
        }
        System.out.println(" ]");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = top; i >= 0; i--) {
            sb.append(stack[i]);
            if (i != 0) sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
