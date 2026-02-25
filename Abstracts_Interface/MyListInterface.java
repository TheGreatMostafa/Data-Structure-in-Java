package Abstracts_Interface;
public interface MyListInterface<Item> {
    public void add(Item item);
    public void add(int index, Item item);

    public void remove(int index);

    public boolean contains(Item item);

    public void set(int index, Item item);
    public Item get(int index);

    public int getSize();

    public int indexOf(Item item);
    public int lastIndexOf(Item item);

    public void clear();
}
