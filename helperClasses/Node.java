package helperClasses;

public class Node<Item> {
    public Item data;
    public Node<Item> next;
    public Node<Item> prev;

    public Node(Item data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Item getData() {
        return data;
    }

    public String toString() {
        return String.valueOf(data) + " " + next;
    }
}
