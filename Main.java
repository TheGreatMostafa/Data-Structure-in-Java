import LinkedList.MyDoublyLinkedList;
import LinkedList.MyLinkedList;
import Stack.MyArrayStack;
import List.MyList;
import Queue.MyArrayQueue;
import HeapTree.MyMaxHeapTree;

public class Main {
    public static void main(String[] args) {
        
        // MyArrayStack<Integer> stack1 = new MyArrayStack<Integer>();
        // stack1.push(10);
        // stack1.push(20);
        // stack1.push(30);
        // stack1.push(40);
        // stack1.push(50);
        // stack1.push(60);
        // System.out.println(stack1.toString());
        // stack1.pop();
        // System.out.println(stack1.toString());
        // System.out.println("Top: " +stack1.peek());
        // System.out.println("Contains null ? : " +stack1.contains(null));
        // System.out.println("Contains 50 ? : " +stack1.contains(50));
        // System.out.println("is Empty ? : " +stack1.isEmpty());
        // System.out.println("is Full ? : " +stack1.isFull());
        // System.out.println("Capacity: " +stack1.getCapacity());
        // System.out.println("Size: "+stack1.getSize());

        // MyArrayQueue<Integer> queue = new MyArrayQueue<>(3);

        // // Test enqueue
        // System.out.println("\n-- Enqueue Test --");
        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);
        // System.out.println("Queue after enqueue 10, 20, 30: " + queue);
        // System.out.println("Size: " + queue.size() + " | Capacity: " + queue.getCapacity());

        // // Test automatic expansion
        // System.out.println("\n-- Expansion Test --");
        // queue.enqueue(40); // should trigger expand()
        // System.out.println("Queue after enqueue 40 (expands automatically): " + queue);
        // System.out.println("Size: " + queue.size() + " | Capacity: " + queue.getCapacity());

        // // Test dequeue
        // System.out.println("\n-- Dequeue Test --");
        // int removed = queue.dequeue();
        // System.out.println("Dequeued: " + removed);
        // System.out.println("Queue after dequeue: " + queue);
        // System.out.println("Front element (peek): " + queue.peek());
        // System.out.println("Size: " + queue.size());

        // // Test wrap-around behavior
        // System.out.println("\n-- Wrap-around Test --");
        // queue.enqueue(50);
        // queue.enqueue(60);
        // queue.enqueue(70);
        // System.out.println("Queue after wrap-around enqueues: " + queue);
        // System.out.println("Front index wraps correctly!");

        // // Test contains()
        // System.out.println("\n-- Contains Test --");
        // System.out.println("Contains 20? " + queue.contains(20));
        // System.out.println("Contains 100? " + queue.contains(100));

        // // Test clear()
        // System.out.println("\n-- Clear Test --");
        // queue.clear();
        // System.out.println("Queue after clear: " + queue);
        // System.out.println("Is empty? " + queue.isEmpty());

        // // Test enqueue after clear
        // queue.enqueue(999);
        // System.out.println("\nQueue after enqueue 999: " + queue);

        // // Test with String queue
        // System.out.println("\n-- String Queue Test --");
        // MyArrayQueue<String> words = new MyArrayQueue<>(2);
        // words.enqueue("Hello");
        // words.enqueue("World");
        // words.enqueue("Mostafa");
        // System.out.println("String queue: " + words);
        // System.out.println("Dequeued: " + words.dequeue());
        // System.out.println("After dequeue: " + words);
        // System.out.println("Capacity : " +words.getCapacity());

        // System.out.println("\n=== All tests completed successfully ===");

        Integer[] array1 = {50,10,40,20,30};

        MyMaxHeapTree<Integer> heap1 = new MyMaxHeapTree<>();
        MyMaxHeapTree<Integer> heap2 = new MyMaxHeapTree<>(20);
        MyMaxHeapTree<Integer> heap3 = new MyMaxHeapTree<>(array1);

        heap1.insert(60);
        heap1.insert(70);
        heap1.insert(80);
        heap1.insert(90);
        heap1.insert(100);
        heap1.insert(110);

        System.out.println("\n--- Testing Delete Max ---");
        System.out.println("Deleted Max: " + heap1.deleteMax()); // Should be 110
        heap1.printHeapTree(); // Root should now be 100 or 90 depending on swap

        System.out.println("\n--- Testing Heap Sort ---");
        heap1.heapSort();
        System.out.print("Sorted Array: ");
        heap1.printHeap(); // Should print: 60 70 80 90 100
    }
}


// MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        // list.addAtFirst(1);
        // list.add(2);
        // list.addAtFirst(3);
        // list.add(2, 4);
        // System.out.println(list.toString());

        // MyLinkedList<String> list2 = new MyLinkedList<String>("Mostafa");
        // System.out.println(list2.toString());
        // list2.add("Ahmed");
        // System.out.println(list2.toString());
        // list2.remove();
        // System.out.println(list2.toString());
        // list2.addAtFirst("Mohamed");
        // list2.add("Ali");
        // list2.remove(1);
        // System.out.println(list2.toString());

        // MyDoublyLinkedList<Integer> list4 = new MyDoublyLinkedList<Integer>(5);
        // System.out.println(list4.toString());
        // list4.add(1, 4);
        // System.out.println(list4.toString());