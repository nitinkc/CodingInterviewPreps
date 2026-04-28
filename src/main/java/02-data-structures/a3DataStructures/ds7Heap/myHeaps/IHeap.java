package a3DataStructures.ds7Heap.myHeaps;

/**
 * Created by Nitin Chaurasia on 3/8/17 at 6:17 PM.
 */
public interface IHeap {
    boolean insert(int item);
    void trickleUp(int currentIndex);

    int remove();
    void trickleDown(int index, int upto);

    //Gives the maximum or minimum depending on MaxHep or MinHeap Implementation
    int getRoot();
    void heapsort();
    boolean isFull();

}
