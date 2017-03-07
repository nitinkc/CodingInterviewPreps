package a2Algorithms.sorting.merge.nitin;

/**
 * Created by Nitin Chaurasia on 3/21/15 at 10:44 AM.
 */
public class MergeSort {
    static int[] A = {1,3,5,7,9,2,4,6,8,10,11,23,34,56};
    public static void main(String[] args) {

        mergeSort(0, A.length-1);
        // first = 0, last = 9

        System.out.println();
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    private static void mergeSort(int first, int last) {

        if (last == first)
            return;
        else {
            int mid = ((last + first) / 2);
            mergeSort(first,mid);
            mergeSort(mid+1,last);
            merge(first,mid,last);
        }
    }

    private static void merge(int first, int mid, int last) {
        int n1 = mid - first + 1;//4-0+1 = 5
        int n2 = last - mid;//9-4 = 5

        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        //n1 = 5;
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        for (int i = 0; i < n1; i++) {
            left[i] = A[first + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = A[mid + i + 1];
        }

        int iLeft = 0;
        int iRight = 0;
        for (int i = first; i <= last; i++) {
            if (left[iLeft] <= right[iRight]) {
                A[i] = left[iLeft];
                iLeft++;
            } else {
                A[i] = right[iRight];
                iRight++;
            }
        }
    }
}
