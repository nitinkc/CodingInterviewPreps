package a2Algorithms.sorting;

/**
 * Created by Nitin Chaurasia on 3/22/15 at 10:00 PM.
 */
public class QuickSort {
    static int[] A = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 11, 23, 34, 56};

    public static void main(String[] args) {

        quickSort(0, A.length - 1);
        // first = 0, last = 9

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    private static void quickSort(int first, int last) {
        if(first < last){
            int mid = partition(first, last);
            quickSort(first,mid);
            quickSort(mid+1,last);
        }
    }

    private static int partition(int first, int last) {
        int x = A[last];

        int i = first - 1;

        for (int j = first ; j < last - 1; j++) {
            if(A[j] <= x){
                i++;
                //Swap
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                //SWAP ENDS
            }
            else{
                //Swap
                int temp = A[i+1];
                A[i+1] = A[last];
                A[last] = temp;
                //SWAP ENDS
            }
        }
        return i;
    }
}
