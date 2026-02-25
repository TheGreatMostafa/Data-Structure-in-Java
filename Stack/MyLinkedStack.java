package Stack;

import helperClasses.Node;

public class MyLinkedStack<Item> {
    private Node<Item> myTop; // First
    private int size;
    
    // Constructors
    public MyLinkedStack() {
        myTop = null;
        size = 0;
    }
    public MyLinkedStack(Item[] items) {
        if(items == null) throw new IllegalArgumentException("Items of Array can't be null.");

        for(Item item : items) push(item);
    }

    // Push (Add to top)
    public void push(Item item) {
        Node<Item> newPtr = new Node<>(item);
        newPtr.next = myTop;
        myTop = newPtr;
        size++;
    }

    // Pop (Remove from top)
    public Item pop() {
        if(isEmpty()) throw new IllegalStateException("Stack is empty.");
        Item value = myTop.data;
        myTop = myTop.next;
        size--;
        return value;
    }

    // Peek (Return top element without removing)
    public Item peek() {
        if(isEmpty()) throw new IllegalStateException("Stack is empty.");

        return myTop.data;
    }

    // isEmpty
    public boolean isEmpty() {
        return myTop == null;
    }

    // Clear
    public void clear() {
        myTop = null;
        size = 0;
    }

    // Contains
    public boolean contains(Item item) {
        Node<Item> currentNode = myTop;

        while(currentNode != null) {
            if (item == null ? currentNode.data == null : item.equals(currentNode.data)) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    // Get size
    public int getSize() {
        return size;
    }

    // toString
    @Override
    public String toString() {
        if(isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Node<Item> currentNode = myTop;
        while(currentNode != null) {
            sb.append(currentNode.data);
            if(currentNode.next != null) sb.append(", ");
            currentNode = currentNode.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
