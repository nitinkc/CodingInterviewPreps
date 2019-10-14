package a1DataStructures.ds7Heap.PriorityQueues;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class App {

    public static void main(String[] args) {

        // primitive types
//        Queue<String> pQueue = new PriorityQueue<>();
//
//        pQueue.add("F");
//        pQueue.add("C");
//        pQueue.add("Z");
//        pQueue.add("A");
//
//        System.out.println(pQueue.remove());
//        System.out.println(pQueue.remove());
//        System.out.println(pQueue.remove());
//        System.out.println(pQueue.remove());

        // custom objects

        Queue<Person> queue = new PriorityQueue<>();
        queue.add(new Person("Balazs", 55));
        queue.add(new Person("Adam", -1));
        queue.add(new Person("Joe", 123));
        queue.add(new Person("Agi", 37));
        queue.add(new Person("Nitin",234));
        
        // O(logN)add(new Person("Balazs", 55));
        //        queue.add

        Queue<Person> pQueue = new PriorityQueue<>();
        pQueue.add(new Person("Balazs", 55));
        pQueue.add(new Person("Adam", -1));
        pQueue.add(new Person("Joe", 123));
        pQueue.add(new Person("Agi", 37));

        //running the Iterator
        Iterator itr = pQueue.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next() + "\t");
        }
        System.out.println();
        // O(logN)
        System.out.println(pQueue.remove());
        System.out.println(pQueue.remove());
        System.out.println(pQueue.remove());
        System.out.println(pQueue.remove());

    }
}
