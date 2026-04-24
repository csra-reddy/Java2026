public class SingleLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    // 1, 2, 4, 5

    public void insertAt(int index, int data) {
        Node newNode = new Node(data);
        if(index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for(int i=0; i<index-1; i++) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = newNode;
            newNode.next = temp;
        }
    }

    public void reverse() {
        if(head == null) {
            return;
        }
        Node current = head;
        Node previous = null;

        while(current != null) {
            Node saveTemp = current.next;
            current.next = previous;
            previous = current;
            current = saveTemp;
        }
        head = previous;
    }

    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }


    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insert(1);
        singleLinkedList.insert(2);
        singleLinkedList.insert(3);

        System.out.println("Original List");
        singleLinkedList.printList();

        singleLinkedList.reverse();
        System.out.println("Reversed List");
        singleLinkedList.printList();

    }
}
