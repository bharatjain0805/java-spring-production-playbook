package collections;

import java.util.PriorityQueue;

record Job(String name, int priority) {}

public class TaskScheduler {
    public static void runJobs() {
        PriorityQueue<Job> queue = new PriorityQueue<>((j1, j2) -> Integer.compare(j2.priority(), j1.priority()));
        queue.add(new Job("Email Report", 2));
        queue.add(new Job("Database Backup", 5));
        queue.add(new Job("UI Refresh", 3));

        while (!queue.isEmpty()) {
            System.out.println("Executing: " + queue.poll());
        }
    }
}
