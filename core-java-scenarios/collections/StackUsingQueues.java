package collections;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        // Push new element to helper queue
        q2.offer(x);
        // Drain main queue behind new element
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        // Swap references
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) throw new IllegalStateException("Stack Empty");
        return q1.poll();
    }

    public int peek() {
        if (q1.isEmpty()) throw new IllegalStateException("Stack Empty");
        return q1.peek();
    }
}
