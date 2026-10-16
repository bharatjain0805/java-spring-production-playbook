package collections;

public class CircularArrayQueue {
    private final int[] arr;
    private int front = 0, rear = 0, size = 0;
    private final int capacity;

    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public boolean enqueue(int x) {
        if (size == capacity) return false; // Full
        arr[rear] = x;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    public int dequeue() {
        if (size == 0) throw new IllegalStateException("Queue Empty");
        int val = arr[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }
}
