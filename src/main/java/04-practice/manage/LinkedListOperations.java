package manage;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nitin Chaurasia on 10/25/15 at 6:39 PM.
 */
public class LinkedListOperations {

    public static void main(String[] args){
        LinkedListOperations listOperations = new LinkedListOperations();
        int[] arr = {1,1,2,2,3,4,5,1,7,8,10,1,3,2};
        Node head = listOperations.createListFromArray(arr);
        listOperations.printList(head);
        listOperations.removeDuplicateWithBuffer(head);
        listOperations.printList(head);
    }

    public void removeDuplicateWithoutBuffer(Node head) {
        if (head == null || head.next == null)
            return;

        Node curr = head;
        Node runner, prev;

        while (curr.next != null) {
            prev = curr;
            runner = curr.next;

            while (runner != null) {
                // remove duplicate node
                if (curr.data == runner.data) {
                    prev.next = runner.next;
                } else {
                    prev = prev.next;
                }
                runner = runner.next;
            }
            curr = curr.next;
        }
    }

    public void removeDuplicateWithBuffer(Node head) {
        if (head == null || head.next == null)
            return;

        Node curr = head.next;
        Node prev = head;

        Set<Integer> set = new HashSet<Integer>();
        set.add(head.data);
        while (curr != null) {
            int temp = curr.data;
            if(set.contains(temp)){// remove the node
                prev.next = curr.next;
            }
            else{
                set.add(temp);
                prev = prev.next;
            }
            curr = curr.next;
        }
    }

    public Node createListFromArray(int[] arr) {
        Node head = null;
        Node curr = null;
        for (int i = 0; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            if (head == null) {
                head = temp;
                curr = head;
            } else {
                curr.next = temp;
                curr = temp;
            }
        }
        return head;
    }

    public void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print("-" + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }


}
