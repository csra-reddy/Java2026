import java.util.Objects;

public class CustomHashMap<K, V> {
    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 16;
    private Node<K, V>[] buckets;

    public CustomHashMap() {
        buckets = new Node[capacity];
    }

    public void put(K key, V value) {
        int hash = (key == null) ? 0 : key.hashCode();
        int index = (capacity-1) & hash;

        Node<K, V> head = buckets[index];

        if(head == null) {
            buckets[index] = new Node<>(key, value);
            return;
        }
        Node<K, V> current = head ;
        while (true) {
            if (Objects.equals(current.key, key)) {
                current.value = value;
                return;
            }

            if(current.next == null) {
                current.next = new Node<>(key, value);
                return;
            }
            current = current.next;
        }

    }

    public V get(K key) {
        int hash = (key == null) ? 0 : key.hashCode();
        int index = (capacity-1) & hash;

        Node<K, V> current = buckets[index];
        while(current != null) {
            if(Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }
}
