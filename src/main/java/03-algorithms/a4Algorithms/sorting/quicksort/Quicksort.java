package a4Algorithms.sorting.quicksort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Quicksort {
    private final int[] result;
    
    public void sort() {
        quicksort(0, result.length - 1);
    }

    private void quicksort(int low, int high) {
        if (low >= high) {//Breaking out of quicksort
            return;
        }
        int pivotIndex = partition(low, high);
        quicksort(low, pivotIndex - 1);
        quicksort(pivotIndex + 1, high);
    }

    private int partition(int low, int high) {
        int pivotIndex = (low + high) / 2; // random index maybe better
        swap(pivotIndex, high);  // set the pivot to the end of list

        int pivot = low;
        for (int j = low; j < high; ++j) {
            if (result[j] <= result[high]) {
                swap(pivot, j);
                pivot++;
            }
        }

        swap(pivot, high); // swap back the pivot
        return pivot;
    }

    private void swap(int i, int j) {
        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
    }

    public void showArray() {
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i] + "  ");
        }
    }
}
