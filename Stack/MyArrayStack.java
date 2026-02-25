package Stack;

public class MyArrayStack<Item> {
    private int capacity;
    private int size = 0;
    private int myTop; // Index for Top of Stack
    private Item[] stack;

    // Constructors
    public MyArrayStack() {
        this(10); // Calling Constructor with capacity signature
    }
    public MyArrayStack(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity must be positive.");

        this.capacity = capacity;
        stack = (Item[]) new Object[capacity];
        myTop = -1;
    }
    public MyArrayStack(Item[] items) {
        if (items == null) throw new IllegalArgumentException("Items array can't be null.");

        capacity = Math.max(10, items.length);
        stack = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, stack, 0, items.length);

        size = items.length;
        myTop = size - 1;
    }


    // Push (Add to Top of Stack)
    public void push(Item item) {
        if (isFull()) expand();

        stack[++myTop] = item;
        size++;
    }

    // Pop (Remove from Top of Stack)
    public Item pop() {
        if(size == 0) throw new IllegalStateException("Stack is empty.");

        Item topValue = (Item) stack[myTop];
        stack[myTop--] = null;
        size--;
        return topValue;
    }

    // Peek (returns Element on Top of Stack)
    public Item peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty.");

        return (Item) stack[myTop];
    }

    // isFull (check if Stack is Full or not)
    public boolean isFull() {
        return myTop == capacity - 1;
    }

    // ifEmpty(check if Stack is Empty or not)
    public boolean isEmpty() {
        return myTop == -1;
    }

    // Expand (Expand capacity of Stack)
    public void expand() {
        capacity *= 2;
        Item[] newStack = (Item[]) new Object[capacity];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    // Clear (Remove all Items in Stack)
    public void clear() {
        for(int i = myTop; i >= 0; i--) stack[i] = null;
        size = 0;
        myTop = -1;
    }
    
    // Contains
    public boolean contains(Item item) {
        if (item == null) { 
            for (int i = myTop; i >= 0; i--) {
                if (stack[i] == null)
                    return true;
            }
        } else {
            for (int i = myTop; i >= 0; i--) {
                Object element = stack[i];
                if (element == item || (element != null && element.equals(item)))
                    return true;
            }
        }
        return false;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= myTop; i++) {
            sb.append(stack[i]);
            if (i < myTop) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
