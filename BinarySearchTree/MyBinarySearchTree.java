public class MyBinarySearchTree<E extends Comparable<E>> {
    private Node root;
    private int size;


    private class Node {
        E data;
        Node left;
        Node right;

        public Node(E data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public MyBinarySearchTree() {
        this.root = null;
        size = 0;
    }

    public void insert(E element) {
        root = insertRec(root, element);
        size++;
    }
    private Node insertRec(Node current, E element) {
        if(current == null) return new Node(element);

        if(element.compareTo(current.data) < 0) current.left = insertRec(current.left, element);
        else if(element.compareTo(current.data) > 0) current.right = insertRec(current.right, element);

        return current;
    }
    public void insertAll(E... elements) {
        for (E e : elements) {
            insert(e);
        }
    }

    public void remove(E element) {
        root = removeRec(root, element);
        size--;
    }

    private Node removeRec(Node current, E element) {
        if (current == null) {
            return null;
        }

        if (element.compareTo(current.data) < 0) current.left = removeRec(current.left, element);
        else if (element.compareTo(current.data) > 0) current.right = removeRec(current.right, element);
        else {
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            current.data = minValue(current.right);
            current.right = removeRec(current.right, current.data);
        }

        return current;
    }
    private E minValue(Node root) {
        E minVal = root.data;
        while (root.left != null) {
            minVal = root.left.data;
            root = root.left;
        }
        return minVal;
    }

    public boolean search(E element) {
        return searchRec(root, element);
    }
    private boolean searchRec(Node current, E element) {
        if(current == null) return false;

        if(element.compareTo(current.data) == 0) return true;
        else if (element.compareTo(current.data) < 0) return searchRec(current.left, element);
        else return searchRec(current.right, element);
    }

    public void printInOrder() {
        inOrderRec(root);
        System.out.println();
    }
    private void inOrderRec(Node current) {
        if(current != null) {
            inOrderRec(current.left);
            System.out.print(current.data + " ");
            inOrderRec(current.right);
        }
    }

    public void printPreOrder() {
        preOrderRec(root);
        System.out.println();
    }
    private void preOrderRec(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preOrderRec(current.left);
            preOrderRec(current.right);
        }
    }

    public void printPostOrder() {
        postOrderRec(root);
        System.out.println();
    }
    private void postOrderRec(Node current) {
        if (current != null) {
            postOrderRec(current.left);
            postOrderRec(current.right);
            System.out.print(current.data + " ");
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
