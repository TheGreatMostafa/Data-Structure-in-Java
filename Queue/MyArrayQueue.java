package Queue;

public class MyArrayQueue<Item> {
    private int myBack; // hold the index of queue end which is an empty place to enqueue to.
    private int myFront; // hold the index of front element (to dequeue next).
    private int size;
    private int capacity;
    private Item[] queue;

    private static final int INITIAL_CAPACITY = 10;

    // Constructors
    public MyArrayQueue() {
        this(INITIAL_CAPACITY);
    }
    public MyArrayQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be greater than 0");

        this.capacity = capacity;
        queue = (Item[]) new Object[capacity];
        myBack = 0;
        myFront = 0;
        size = 0;
    }
    public MyArrayQueue(int capacity, Item item) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be greater than 0");
        
        this.capacity = capacity;
        queue = (Item[]) new Object[capacity];
        queue[0] = item;
        size = 1;
        myBack = 1;
        myFront = 0;
    }
    public MyArrayQueue(Item item) {
        this(INITIAL_CAPACITY, item);
    }
    public MyArrayQueue(Item[] items) {
        if (items == null) throw new IllegalArgumentException("Array can't be null");

        capacity = Math.max(INITIAL_CAPACITY, items.length);
        queue = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, queue, 0, items.length);
        size = items.length;
        myBack = size % capacity;
        myFront = 0;
    }

    // Enqueue
    public void enqueue(Item item) {
        if(isFull()) expand();

        queue[myBack] = item;
        myBack = (myBack + 1) % capacity;
        size++;
    }

    // Dequeue
    public Item dequeue() {
        if(isEmpty()) throw new IllegalStateException("Queue is Empty");

        Item itemDequeued = queue[myFront];
        queue[myFront] = null;
        myFront = (myFront + 1) % capacity;
        size--;
        return itemDequeued;
    }

    // Peek
    public Item peek() {
        if(isEmpty()) throw new IllegalStateException("Queue is Empty");

        return queue[myFront];
    }

    // Get Capacity
    public int getCapacity() {
        return capacity;
    }

    // Get Size 
    public int size() {
        return size;
    }

    // Get Clear
    public void clear() {
        java.util.Arrays.fill(queue, null);
        size = 0;
        myBack = myFront = 0;
    }

    // Is Empty ?
    public boolean isEmpty() {
        return size == 0;
    }

    // Is Full ?
    public boolean isFull() {
        return size == capacity;
    }

    // Expand (Multiply Capacity)
    private void expand() {
        if (!isFull()) return;

        int newCapacity = capacity * 2;
        Item[] newQueue = (Item[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            int index = (myFront + i) % capacity;
            newQueue[i] = queue[index];
        }

        queue = newQueue;
        capacity = newQueue.length;
        myFront = 0;
        myBack = size;
    }

    // Contains item ?
    public boolean contains(Item item) {
        if(isEmpty()) throw new IllegalStateException("Queue is Empty");

        for(int i = 0; i < size; i++) {
            int index = (myFront + i) % capacity;
            if (queue[index] == null ? item == null : queue[index].equals(item)) {
                return true;
            }
        }
        return false;
    }

    // toString
    @Override
    public String toString() {
        if(isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < size; i++) {
            int index = (myFront + i) % capacity;
            sb.append(queue[index]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
