package collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {
    public static Character findFirst(String input) {
        Map<Character, Integer> counts = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return null;
    }
}
