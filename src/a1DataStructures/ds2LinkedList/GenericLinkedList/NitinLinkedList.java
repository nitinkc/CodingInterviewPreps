package a1DataStructures.ds2LinkedList.GenericLinkedList;

/**
 * Created by Nitin Chaurasia on 4/9/16 at 1:08 AM.
 */
public interface NitinLinkedList {

    public void add(int index, Object element);

    /* Add an element in the beginning of the List */
    public void addFirst(Object o);

    /* Add an element to the end of the list */
    public void addLast(Object o);

    /* Deleting the entire List */
    public void clear();

    /* Checks if a particular element exists or not*/
    public boolean contains(Object o);

    /* Getting the element from a particular index */
    public Object get(int index);

    /* Getting the first element */
    public Object getFirst();

    /* Getting the last element of the list*/
    public Object getLast();

    /* Deleting the entire List*/
    public int indexOf(Object o);

    /* Getting the last index of the List */
    public int lastIndexOf(Object o);

    /* Remove a particular element at Index */
    public Object remove(int index);

    /* Deleting the entire List*/
    public boolean remove(Object o);

    /* Deleting the entire List*/
    public Object removeFirst() ;

    /* Deleting the entire List*/
    public Object removeLast();

    /* Deleting the entire List*/
    public Object set(int index, Object element);

    /* Returns the size of the Linked List */
    public int size();

    /* Looking into the entire list */
    public void peek();
}
