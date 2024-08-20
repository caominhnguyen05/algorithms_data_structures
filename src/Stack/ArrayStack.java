package Stack;

public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int size = 0;
    public ArrayStack() {
        this(CAPACITY);
    }
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void push(E e) throws IllegalStateException {
        if (size() == 0) {
            throw new IllegalStateException("Stack is full");
        }
        data[size] = e;
        size++;
    }

    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[size-1];
    }
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E result = data[size-1];
        data[size-1] = null;
        size--;
        return result;
    }
}
