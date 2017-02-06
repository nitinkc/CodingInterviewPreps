package dataStructures.GenericLinkedList;

/**
 * Created by Nitin Chaurasia on 4/9/16 at 1:05 AM.
 */

class Node<V> {
    Node next;
    public V o;

    public Node(Node next, V o) {
        this.next = next;
        this.o = o;
    }

    public Node(V o) {
        this.o = o;
        this.next = null;
    }
}


