package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedCounterScenario {
    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        SharedCounterScenario task = new SharedCounterScenario();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) task.increment();
            });
            threads[i].start();
        }

        for (Thread t : threads) t.join();
        System.out.println("Final Count: " + task.counter.get()); // 10000
    }
}
