package Queue;

import helperClasses.Node;

public class MyLinkedQueue<Item> {
    private Node<Item> myFrontPointer; // first node (head)
    private Node<Item> myBackPointer;  // last node (tail)
    private int size;

    // Constructors
    public MyLinkedQueue() {
        myBackPointer = null;
        myFrontPointer = null;
        size = 0;
    }

    public MyLinkedQueue(Item item) {
        Node<Item> newNode = new Node<>(item);
        myFrontPointer = newNode;
        myBackPointer = newNode;
        size = 1;
    }

    public MyLinkedQueue(Item[] items) {
        if (items == null) throw new IllegalArgumentException("Array can't be null");
        if (items.length == 0) {
            myFrontPointer = null;
            myBackPointer = null;
            size = 0;
            return;
        }

        myFrontPointer = new Node<>(items[0]);
        Node<Item> current = myFrontPointer;
        for (int i = 1; i < items.length; i++) {
            Node<Item> newNode = new Node<>(items[i]);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        myBackPointer = current;
        size = items.length;
    }

    // Enqueue (add to the back)
    public void enqueue(Item item) {
        Node<Item> newNode = new Node<>(item);
        if (isEmpty()) {
            myFrontPointer = myBackPointer = newNode;
        } else {
            myBackPointer.next = newNode;
            newNode.prev = myBackPointer;
            myBackPointer = newNode;
        }
        size++;
    }

    // Dequeue (remove from front)
    public Item dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is Empty");

        Item itemDequeued = myFrontPointer.data;
        myFrontPointer = myFrontPointer.next;
        size--;

        if (isEmpty()) myBackPointer = null;

        return itemDequeued;
    }

    // Peek
    public Item peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is Empty");
        return myFrontPointer.data;
    }

    // Contains
    public boolean contains(Item item) {
        if (isEmpty()) throw new IllegalStateException("Queue is Empty");

        Node<Item> currentNode = myFrontPointer;
        while (currentNode != null) {
            if (currentNode.data == null ? item == null : currentNode.data.equals(item)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    // Clear
    public void clear() {
        myBackPointer = null;
        myFrontPointer = null;
        size = 0;
    }

    // Get Size
    public int getSize() {
        return size;
    }

    // is Empty ?
    public boolean isEmpty() {
        return myFrontPointer == null;
    }

    // toString
    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Node<Item> current = myFrontPointer;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
