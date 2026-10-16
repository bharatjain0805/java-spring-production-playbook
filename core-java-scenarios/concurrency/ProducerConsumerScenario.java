package concurrency;

// Implementation via BlockingQueue
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerScenario {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Runnable producer = () -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        };

        Runnable consumer = () -> {
            try {
                while (true) {
                    Integer val = queue.take();
                    System.out.println("Consumed: " + val);
                    if (val == 10) break;
                }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
