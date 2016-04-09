package udemyJobInterview;

/**
 * Created by Nitin Chaurasia on 10/25/15 at 6:35 PM.
 */
public class Node {
    int data;
    Node next;


    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

}
