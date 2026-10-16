package collections;

import java.util.NavigableSet;
import java.util.TreeSet;

public class AutoSuggest {
    public static void main(String[] args) {
        TreeSet<String> dictionary = new TreeSet<>();
        dictionary.addAll(java.util.List.of("apple", "apricot", "banana", "blueberry", "blackberry"));

        String prefix = "bl";
        String end = prefix + Character.MAX_VALUE;
        NavigableSet<String> matches = dictionary.subSet(prefix, true, end, true);
        System.out.println(matches); // [blackberry, blueberry]
    }
}
