package collections;

public class ArrayStack {
    private final int[] arr;
    private int top;
    private final int capacity;

    public ArrayStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (top == capacity - 1) throw new IllegalStateException("Stack Overflow");
        arr[++top] = x;
    }

    public int pop() {
        if (top == -1) throw new IllegalStateException("Stack Underflow");
        return arr[top--];
    }

    public int peek() {
        if (top == -1) throw new IllegalStateException("Stack Empty");
        return arr[top];
    }
}
