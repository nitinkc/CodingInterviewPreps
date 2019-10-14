package a1DataStructures.ds7Heap.myHeaps;

import java.util.Random;

/**
 * Created by Nitin Chaurasia on 3/8/17 at 6:46 PM.
 */
public class Driver {
    public static void main(String[] args) {
        final int SIZE = 10;

        HeapImpl heap = new HeapImpl(SIZE);
        Random rand = new Random();

        for (int i = 0; i < SIZE - 1; i++) {
            int data = rand.nextInt(40);
            System.out.print("\t" + data);
            heap.insert(data);
        }

        System.out.println();
        System.out.println(heap.getRoot());

        System.out.println(heap.remove());
        System.out.println(heap.getRoot());

        System.out.println(heap.remove());
        System.out.println(heap.getRoot());
        System.out.println(heap.remove());
        System.out.println(heap.getRoot());
        System.out.println(heap.remove());
        System.out.println(heap.getRoot());


    }
}
