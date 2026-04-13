import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy nodes (sentinels)
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Get value by key
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;

        removeNode(node);
        addToFront(node); // mark as recently used

        return node.value;
    }

    // Put key-value
    public void put(int key, int value) {
        if (capacity == 0) return;

        Node node = map.get(key);

        if (node != null) {
            node.value = value;
            removeNode(node);
            addToFront(node);
        } else {
            if (map.size() == capacity) {
                // remove LRU (node before tail)
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToFront(newNode);
        }
    }

    // Remove node from list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node right after head
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // For testing
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1)); // 10

        cache.put(3, 30); // evicts key 2

        System.out.println(cache.get(2)); // -1

        cache.put(4, 40); // evicts key 1

        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 30
        System.out.println(cache.get(4)); // 40
    }
}