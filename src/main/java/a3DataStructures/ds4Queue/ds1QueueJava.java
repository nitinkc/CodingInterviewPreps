package a3DataStructures.ds4Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nitin Chaurasia on 2/9/16 at 12:30 AM.
 */
public class ds1QueueJava {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            q.add("Nitin - " + i);
        }
        System.out.println(q.peek());
        q.remove();//Void method, just removes

        //Poll method removes and returns the head of the queue. It returns null if the queue is empty.
        System.out.println(q.poll());
        System.out.println(q.peek());
        // Check if the queue is empty
        System.out.println("Is the queue empty? " + q.isEmpty()); // true

    }
}