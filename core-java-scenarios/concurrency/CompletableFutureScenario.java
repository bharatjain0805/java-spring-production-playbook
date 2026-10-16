package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureScenario {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> {
            simulateLatency(100);
            return "User: Bharat";
        });

        CompletableFuture<String> ordersFuture = CompletableFuture.supplyAsync(() -> {
            simulateLatency(150);
            return "Orders: [ItemA, ItemB]";
        });

        CompletableFuture<String> combined = userFuture.thenCombine(ordersFuture, (u, o) -> u + " | " + o);
        System.out.println(combined.get());
    }

    private static void simulateLatency(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}