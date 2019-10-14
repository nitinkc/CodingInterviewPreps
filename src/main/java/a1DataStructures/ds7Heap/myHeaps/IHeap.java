package a1DataStructures.ds7Heap.myHeaps;

/**
 * Created by Nitin Chaurasia on 3/8/17 at 6:17 PM.
 */
public interface IHeap {
    public boolean insert(int item);
    public void trickleUp(int currentIndex);

    public int remove();
    public void trickleDown(int index, int upto);

    //Gives the maximum or minimum depending on MaxHep or MinHeap Implementation
    public int getRoot();
    public void heapsort();
    public boolean isFull();

}
