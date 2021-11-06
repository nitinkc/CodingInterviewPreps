package a1DataStructures.ds7Heap.PriorityQueues;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class JavaHeap {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();

        Random generator = new Random(); //or new Random(123), 123 being the seed

        int loop = generator.nextInt();
        for (int i = 0; i < loop ; i++) {
            pq.add(generator.nextInt());
        }

        for (int i = 0; i < loop; i++) {
            System.out.print(pq.poll() + "\t");
        }
    }
}
