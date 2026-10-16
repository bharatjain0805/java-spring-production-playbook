package concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ApiRequestCounter {
    private final ConcurrentHashMap<String, AtomicInteger> counts = new ConcurrentHashMap<>();

    public void recordRequest(String user) {
        counts.computeIfAbsent(user, k -> new AtomicInteger()).incrementAndGet();
    }

    public int getCount(String user) {
        return counts.getOrDefault(user, new AtomicInteger(0)).get();
    }
}
