import java.util.Objects;

public class MyHashMap<K, V> {

    // Node class
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 16;
    private Node<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        buckets = new Node[capacity];
    }

    // Hash function (safe + better distribution)
    private int getIndex(K key) {
        int hash = (key == null) ? 0 : key.hashCode();
        hash ^= (hash >>> 16); // spread bits
        return (capacity - 1) & hash;
    }

    // PUT
    public void put(K key, V value) {
        int index = getIndex(key);

        Node<K, V> head = buckets[index];

        // Empty bucket
        if (head == null) {
            buckets[index] = new Node<>(key, value);
            return;
        }

        Node<K, V> current = head;

        while (true) {
            // Key match → update
            if (Objects.equals(current.key, key)) {
                current.value = value;
                return;
            }

            // End of list → insert
            if (current.next == null) {
                current.next = new Node<>(key, value);
                return;
            }

            current = current.next;
        }
    }

    // GET
    public V get(K key) {
        int index = getIndex(key);

        Node<K, V> current = buckets[index];

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    // Optional: for debugging
    public void printMap() {
        for (int i = 0; i < capacity; i++) {
            Node<K, V> current = buckets[i];
            if (current != null) {
                System.out.print("Bucket " + i + ": ");
                while (current != null) {
                    System.out.print("[" + current.key + "=" + current.value + "] -> ");
                    current = current.next;
                }
                System.out.println("null");
            }
        }
    }
}