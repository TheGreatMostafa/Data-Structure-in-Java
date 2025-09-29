public class MyList<Item> {
    private Item[] array;
    private int size;

    // Constructors
    public MyList(){
        this.array = (Item[]) new Object[10];
        size = 0;
    }
    public MyList(int capacity){
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity must be a positive number.");
        this.array = (Item[]) new Object[capacity];
        size = 0;
    }
    public MyList(Item... items){
        this.array = (Item[]) new Object[items.length + 10];
        this.size = items.length;

        System.arraycopy(items, 0, this.array, 0, items.length);
    }

    // Set and Get
    public Item get(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return array[index];
    }
    public void set(Item item, int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        array[index] = item;
    }

    // Check if List is Either Empty of Full or Neither and check size
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == array.length;
    }
    public int size(){
        return this.size;
    }

    // Operations like Resizing List by increasing capacity, Add an item to an index or at last, Remove an item to an index or from last
    private  void resize(){
        int newCapacity = array.length * 2;
        Item[] newArray = (Item[]) new Object[newCapacity];

        for (int i = 0; i < size; i++)
            newArray[i] = array[i];
        this.array = newArray;
    }
    public void add(Item item, int index){
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        
        if(isFull())
            resize();
        
        for (int i = size; i > index; i--)
            array[i] = array[i-1];
        array[index] = item;
        size++;
    }
    public void add(Item item){
        add(item, this.size);
    }
    public void remove(int index){
        if(isEmpty())
            return;
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        
        for (int i = index; i < size-1; i++)
            array[i] = array[i+1];
        size--;
        array[size] = null;
    }
    public void remove(){
        if(isEmpty())
            return;
        remove(this.size - 1);
    }

    // toString()
    @Override
    public String toString(){
        if(isEmpty())
            return "[]";
        
        String result = "[" + array[0];
        for (int i = 1; i < size; i++)
            result += ", " + array[i];
        result += "]";
        return result;
    }
}   
