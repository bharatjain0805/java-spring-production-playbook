package collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class RollingLogBuffer {
    private final int capacity = 100;
    private final Queue<String> logs = new ArrayDeque<>();

    public synchronized void addLog(String log) {
        if (logs.size() == capacity) {
            logs.poll(); // Evict oldest
        }
        logs.offer(log); // Append newest
    }
}
