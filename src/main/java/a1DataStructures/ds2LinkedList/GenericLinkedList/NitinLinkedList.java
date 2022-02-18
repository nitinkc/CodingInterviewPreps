package a1DataStructures.ds2LinkedList.GenericLinkedList;

/**
 * Created by Nitin Chaurasia on 4/9/16 at 1:08 AM.
 */
public interface NitinLinkedList {

    void add(int index, Object element);

    /* Add an element in the beginning of the List */
    void addFirst(Object o);

    /* Add an element to the end of the list */
    void addLast(Object o);

    /* Deleting the entire List */
    void clear();

    /* Checks if a particular element exists or not*/
    boolean contains(Object o);

    /* Getting the element from a particular index */
    Object get(int index);

    /* Getting the first element */
    Object getFirst();

    /* Getting the last element of the list*/
    Object getLast();

    /* Deleting the entire List*/
    int indexOf(Object o);

    /* Getting the last index of the List */
    int lastIndexOf(Object o);

    /* Remove a particular element at Index */
    Object remove(int index);

    /* Deleting the entire List*/
    boolean remove(Object o);

    /* Deleting the entire List*/
    Object removeFirst() ;

    /* Deleting the entire List*/
    Object removeLast();

    /* Deleting the entire List*/
    Object set(int index, Object element);

    /* Returns the size of the Linked List */
    int size();

    /* Looking into the entire list */
    void peek();
}
