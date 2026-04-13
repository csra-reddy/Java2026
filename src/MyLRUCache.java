import java.util.HashMap;
import java.util.Map;

public class MyLRUCache {

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    Map<Integer, Node> cache = new HashMap<Integer, Node>();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToStart(Node node) {
        node.next = head.next;
        node.prev = head;

        node.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        removeNode(node);
        addToStart(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if(node != null) { //Case 1: If Key exists, update and move to front
            node.value = value;
            removeNode(node);
            addToStart(node);
        } else {
            if (cache.size() == capacity) { //Case 2: If cache is full, remove lru from linkedlist and map too
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
            //Case 3: Insert new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToStart(newNode);
        }
    }

    public static void main(String[] args) {
        MyLRUCache cache = new MyLRUCache(2);

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
