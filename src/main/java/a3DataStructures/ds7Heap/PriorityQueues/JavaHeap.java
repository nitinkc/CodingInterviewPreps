package a3DataStructures.ds7Heap.PriorityQueues;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class JavaHeap {
    public static void main(String[] args) {
        //Queue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Random generator = new Random(100); //or new Random(123), 123 being the seed
        int loop = 10;//generator.nextInt();

        for (int i = 0; i < loop ; i++) {
            pq.add(generator.nextInt(100));
        }

        for (int i = 0; i < loop; i++) {
            System.out.print(pq.poll() + "\t");
        }
    }
}
