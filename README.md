<div align="center">

# ☕ Data Structures in Java

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)

A comprehensive, ground-up implementation of fundamental data structures in Java. This repository serves as an educational tool and a practical reference for understanding how data structures operate under the hood.

</div>

<br/>

## 📚 Implemented Data Structures

This project includes custom implementations of the following data structures, built using generic types (`<Item>`) for flexibility:

### 1. Lists (`/List` & `/LinkedList`)
* **Dynamic Array List (`MyList`)**: An auto-resizing array implementation.
* **Singly Linked List (`MyLinkedList`)**: A standard linked list using custom `Node` objects.
* **Doubly Linked List (`MyDoublyLinkedList`)**: A linked list with `prev` and `next` pointers for bi-directional traversal.

### 2. Stacks (`/Stack`)
* **Array-Based Stack (`MyArrayStack`)**: A LIFO (Last-In-First-Out) data structure utilizing dynamic arrays.
* **Linked Stack (`MyLinkedStack`)**: A LIFO data structure utilizing linked nodes to eliminate capacity restrictions.

### 3. Queues (`/Queue`)
* **Array-Based Circular Queue (`MyArrayQueue`)**: A FIFO (First-In-First-Out) structure featuring wrap-around logic to optimize array space.
* **Linked Queue (`MyLinkedQueue`)**: A FIFO structure utilizing pointers for efficient enqueuing and dequeuing.

### 4. Trees (`/BinarySearchTree` & `/HeapTree`)
* **Binary Search Tree (`MyBinarySearchTree`)**: A node-based tree structure supporting efficient insertion, deletion, and searching, along with In-Order, Pre-Order, and Post-Order traversals.
* **Max Heap Tree (`MyMaxHeapTree`)**: A complete binary tree implementation for priority queuing, featuring `heapify`, `percolateUp`, `percolateDown`, and Heap Sort algorithms. Includes a visual tree-printing utility.

---

## 🚀 Getting Started

### Prerequisites
* Java Development Kit (JDK) 8 or higher installed on your machine.

### Installation
1. Clone the repository:
   ```bash
   git clone [https://github.com/TheGreatMostafa/Data-Structure-in-Java.git](https://github.com/TheGreatMostafa/Data-Structure-in-Java.git)
