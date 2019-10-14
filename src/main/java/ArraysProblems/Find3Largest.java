package ArraysProblems;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Find3Largest {
    public static void main(String[] args) {
        int arr[] = new int[]{10,2,3,4,5,6,7,8,9};
        int ret[] = findLargestThree(arr);

        for (int a :
                ret) {
            System.out.println(a);
        }
    }

    public static int[] findLargestThree(int[] array){
        // Using Heap
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : array){
            pq.add(i);
        }

        int[] a = new int[3];
        a[0] = pq.poll();
        a[1] = pq.poll();
        a[2] = pq.poll();

        return a;
    }
}
