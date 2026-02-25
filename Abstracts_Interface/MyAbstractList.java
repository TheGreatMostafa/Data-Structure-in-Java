package Abstracts_Interface;
public abstract class MyAbstractList<Item> implements MyListInterface<Item> {
    protected int size;

    public void add(Item item) {}
    public void add(int index, Item item) {}
    public void remove(int index) {}

    public boolean isEmpty() {
        return size == 0;
    }
    public int getSize() {
        return size;
    }
}
