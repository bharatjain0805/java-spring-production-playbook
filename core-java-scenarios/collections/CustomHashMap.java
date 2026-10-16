package collections;

public class CustomHashMap<K, V> {
    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        Entry(K key, V value) { this.key = key; this.value = value; }
    }

    private final Entry<K, V>[] buckets;
    private final int capacity = 16;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new Entry[capacity];
    }

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % capacity;
        Entry<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value; // Update
                return;
            }
            head = head.next;
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = buckets[index];
        buckets[index] = newEntry;
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode()) % capacity;
        Entry<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }
}
