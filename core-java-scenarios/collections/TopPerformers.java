package collections;

import java.util.*;

public class TopPerformers {
    public static void printTop3(Map<String, Integer> map) {
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
