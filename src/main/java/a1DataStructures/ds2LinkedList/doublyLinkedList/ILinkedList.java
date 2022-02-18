package a1DataStructures.ds2LinkedList.doublyLinkedList;

public interface ILinkedList {

	//Add Elements to Linked List
    void add(int index, Object element);
	void addFirst(Object element);
	void addLast(Object element);

	// Set an element at a given index with a given element
    void set(int index, Object element);

	//Clean the Linked List
    void clear();

	//Check if an element exists in a Linked List
    boolean contains(Object element);

	// Get methods
    Object get(int index);
	Object getFirst();
	Object getLast();

	//Find the index of a given element
    int indexOf(Object element);
	int lastIndexOf(Object element);

	// Remove Elements
    Object remove(int index);
	boolean remove(Object element);
	Object removeFirst();
	Object removeLast();

	int size();
	void peek();
}
