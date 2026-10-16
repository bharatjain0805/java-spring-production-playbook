package collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostSoldProduct {
    public static int findTopProduct(List<Integer> productIds) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int id : productIds) {
            counts.put(id, counts.getOrDefault(id, 0) + 1);
        }
        return counts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(-1);
    }
}
