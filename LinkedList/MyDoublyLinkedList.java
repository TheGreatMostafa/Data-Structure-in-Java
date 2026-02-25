package LinkedList;
import Abstracts_Interface.MyAbstractList;
import helperClasses.Node;

public class MyDoublyLinkedList<Item> extends MyAbstractList<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size = 0;

    public MyDoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public MyDoublyLinkedList(Item data) {
        Node<Item> newNode = new Node<Item>(data);
        first = newNode;
        last = newNode;
        size = 1;
    }

    public Node<Item> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " & Size: " + size);
        }
        Node<Item> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public void addAtFirst(Item item) {
        Node<Item> newPtr = new Node<>(item);
        newPtr.next = first;
        if (first != null) first.prev = newPtr;
        first = newPtr;
        if (last == null) last = first;
        size++;
    }

    public void add(Item item) {
        Node<Item> newPtr = new Node<>(item);
        if (isEmpty()) {
            first = newPtr;
            last = newPtr;
        } else {
            last.next = newPtr;
            newPtr.prev = last;
            last = newPtr;
        }
        size++;
    }

    @Override
    public void add(int index, Item item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + " & Size: " + size);
        }

        if (index == 0) {
            addAtFirst(item);
        } else if (index == size) {
            add(item);
        } else {
            Node<Item> prePtr = getNode(index - 1);
            Node<Item> newPtr = new Node<>(item);
            newPtr.next = prePtr.next;
            newPtr.prev = prePtr;
            prePtr.next = newPtr;
            newPtr.next.prev = newPtr;
            size++;
        }
    }

    public void removeFirst() {
        if (isEmpty()) 
            return;

        first = first.next;
        if (first == null) last = null; 
        else first.prev = null;
        size--;
    }

    public void remove() {
        if (isEmpty()) 
            return;

        if (size == 1) first = last = null;
        else {
            last = last.prev;
            last.next = null;
        }
        size--;
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " & Size: " + size);
        }

        if(index == 0){
            removeFirst();
        } else if (index == size - 1) {
            remove();
        } else {
            Node<Item> prePtr = getNode(index - 1);
            prePtr.next = prePtr.next.next;
            prePtr.next.prev = prePtr;
            size--;
        }
    }

    @Override
    public void set(int index, Item item) {
        Node<Item> node = getNode(index);
        node.data = item;
    }

    @Override
    public Item get(int index) {
        return getNode(index).data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean contains(Item item) {
        Node<Item> currentNode = first;
        for(int i = 0; i < size; i++) {
            if (item == null ? currentNode.data == null : item.equals(currentNode.data)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public int indexOf(Item item) {
        Node<Item> currentNode = first;
        for(int i = 0 ; i < size ; i++) {
            if (item == null ? currentNode.data == null : item.equals(currentNode.data)) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Item item) {
        Node<Item> currentNode = last;

        for(int i = size - 1 ; i >= 0 ; i--) {
            if (item == null ? currentNode.data == null : item.equals(currentNode.data)) {
                return i;
            }
            currentNode = currentNode.prev;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("[");
        Node<Item> currentNode = first;

        for (int i = 0; i < size; i++) {
            text.append(currentNode.data);
            if (i < size - 1) text.append(", ");
            currentNode = currentNode.next;
        }

        text.append("]");
        return text.toString();
    }
}