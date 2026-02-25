package HeapTree;

@SuppressWarnings("unchecked")
public class MyMaxHeapTree<T extends Comparable<T>> {

    private T[] heap;
    private int size;
    private int capacity;

    private static final int DEFAULT_CAPACITY = 16;

    public MyMaxHeapTree() {
        this(DEFAULT_CAPACITY);
    }

    public MyMaxHeapTree(int capacity) {
        this.capacity = capacity;
        this.heap = (T[]) new Comparable[capacity];
        this.size = 0;
    }

    public MyMaxHeapTree(T[] items) {
        this.capacity = Math.max(DEFAULT_CAPACITY, items.length);
        this.heap = (T[]) new Comparable[this.capacity];
        this.size = items.length;

        System.arraycopy(items, 0, heap, 0, size);
        heapify();
    }

    private void heapify() {
        // Start from last non-leaf node
        for (int i = (size / 2) - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    private void percolateDown(int parent) {
        int c = 2 * parent + 1; // left child

        while (c < size) {
            // if right child exists and is bigger
            if (c + 1 < size && heap[c].compareTo(heap[c + 1]) < 0) {
                c++; // right child
            }

            // if parent is smaller than bigger child → swap
            if (heap[parent].compareTo(heap[c]) < 0) {
                swap(parent, c);
                parent = c;
                c = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    private void percolateUp(int child) {
        int parent = (child - 1) / 2;

        while (child > 0 && heap[child].compareTo(heap[parent]) > 0) {
            swap(child, parent);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public void insert(T item) {
        if (size == capacity) {
            resize();
        }

        heap[size] = item;
        percolateUp(size);
        size++;
    }

    public T deleteMax() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }

        T max = heap[0];
        heap[0] = heap[size - 1];
        size--;

        if (size > 0) {
            percolateDown(0);
        }

        return max;
    }

    public void heapSort() {
        int originalSize = size;

        for(int i = size - 1; i > 0; i--) {
            swap(0, i);
            size--;
            percolateDown(0);
        }
        size = originalSize;
    }

    private void resize() {
        capacity *= 2;
        T[] newHeap = (T[]) new Comparable[capacity];
        System.arraycopy(heap, 0, newHeap, 0, size);
        heap = newHeap;
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printHeap() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if(i == size - 1) {
                System.out.println(heap[i] + "]"); 
                break;
            }
            System.out.print(heap[i] + ", ");
            
        }
        System.out.println();
    }
    
    public void printHeapTree() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return;
        }

        StringBuilder sb = new StringBuilder();
        printHeapRecursive(0, "", true, sb);
        System.out.println(sb.toString());
    }

    // Recursive helper method
    private void printHeapRecursive(int index, String prefix, boolean isLeft, StringBuilder sb) {
        if (index >= size) return;

        sb.append(prefix);
        if (index == 0) {
            sb.append("Root: "); 
        } else {
            // If left child use "├── ", if right child use "└── "
            sb.append(isLeft ? "├── " : "└── ");
        }
        sb.append(heap[index]).append("\n");

        int left = 2 * index + 1;
        int right = 2 * index + 2;
        String childPrefix = prefix + (index == 0 ? "" : (isLeft ? "│   " : "    "));

        if (left < size) {
            printHeapRecursive(left, childPrefix, true, sb);
        }
        if (right < size) {
            printHeapRecursive(right, childPrefix, false, sb);
        }
    }
}
