package LL;

public class linkedDequeue<Item> {
    private Node<Item> nil;  // Sentinel node
    private int n;  // Number of elements in the dequeue

    // Node structure for a doubly linked list
    private static class Node<Item> {
        private Item key;
        private Node<Item> next;
        private Node<Item> prev;

        public Node(Item key) {
            this.key = key;
        }
    }

    // Constructor initializes an empty circular doubly linked list with sentinel node
    public linkedDequeue() {
        nil = new Node<>(null);
        nil.prev = nil;
        nil.next = nil;
        n = 0;
    }

    // Add an item to the front of the deque
    public void pushFront(Item item) {
        Node<Item> newNode = new Node<>(item);
        newNode.next = nil.next;
        newNode.prev = nil;
        nil.next.prev = newNode;
        nil.next = newNode;
        n++;
    }

    // Add an item to the back of the deque
    public void pushBack(Item item) {
        Node<Item> newNode = new Node<>(item);
        newNode.prev = nil.prev;
        newNode.next = nil;
        nil.prev.next = newNode;
        nil.prev = newNode;
        n++;
    }

    // Remove and return the front item
    public Item popFront() {
        if (isEmpty()) throw new RuntimeException("Dequeue underflow");
        Node<Item> front = nil.next;
        Item item = front.key;
        nil.next = front.next;
        front.next.prev = nil;
        n--;
        return item;
    }

    // Remove and return the back item
    public Item popBack() {
        if (isEmpty()) throw new RuntimeException("Dequeue underflow");
        Node<Item> back = nil.prev;
        Item item = back.key;
        nil.prev = back.prev;
        back.prev.next = nil;
        n--;
        return item;
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return n == 0;
    }

    // Get the size of the deque
    public int size() {
        return n;
    }
}
