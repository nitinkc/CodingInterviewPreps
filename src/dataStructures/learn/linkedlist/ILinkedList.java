package dataStructures.learn.linkedlist;

public interface ILinkedList {

	//Add Elements to Linked List
	public void add(int index, Object element);
	public void addFirst(Object element);
	public void addLast(Object element);

	// Set an element at a given index with a given element
	public void set(int index, Object element);

	//Clean the Linked List
	public void clear();

	//Check if an element exists in a Linked List
	public boolean contains(Object element);

	// Get methods
	public Object get(int index);
	public Object getFirst();
	public Object getLast();

	//Find the index of a given element
	public int indexOf(Object element);
	public int lastIndexOf(Object element);

	// Remove Elements
	public Object remove(int index);
	public boolean remove(Object element);
	public Object removeFirst();
	public Object removeLast();

	public int size();
	public void peek();
}
