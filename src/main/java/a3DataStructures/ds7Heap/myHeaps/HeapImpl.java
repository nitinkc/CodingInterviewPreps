package a3DataStructures.ds7Heap.myHeaps;

/**
 * Created by Nitin Chaurasia on 3/8/17 at 6:44 PM.
 *
 * Left child = 2n +1
 * Right child = 2n + 2
 *
 * Parent = (n-1) / 2;
 */
public class HeapImpl implements IHeap{

    private final Integer[] heap;
    private int currentIndex = -1;

    public HeapImpl(int size){
        heap = new Integer[size];
    }

    @Override
    public boolean insert(int item) {

        if (!isFull()){
            //Add the value in the location next to current Index
            heap[++currentIndex] = item;

            // After adding, perform heapification
            trickleUp(currentIndex);

        } else {
            throw new RuntimeException("The Heap is Already Full");
        }
        return true;
    }

    @Override
    public void trickleUp(int currentIndex) {
        int parentIndex = (currentIndex - 1) / 2;

        // Condition for Min Heap (gives Sorting Order)
        // If the value of the child and parent is equal, NO NEED TO SWAP, else its an infinite loop
        while (parentIndex >= 0 && this.heap[currentIndex] < this.heap[parentIndex]){

            //if the node added is less than the parent, swap the elements
            int temp = this.heap[currentIndex];
            this.heap[currentIndex] = this.heap[parentIndex];
            this.heap[parentIndex] = temp;

            // For next while loop iteration
            currentIndex = parentIndex; // checking upwards
            parentIndex = (currentIndex - 1) / 2;
        }
    }

    /**
     * Replace the last element of the Heap with the root
     * @return
     */
    @Override
    public int remove() {
        int ret = this.heap[0];

        //Remove the last element of the Heap and place it on the top
        this.heap[0] = this.heap[currentIndex]; // Hole is filled with the last element

        this.heap[currentIndex] = null;
        currentIndex = currentIndex -1;

        trickleDown(0, currentIndex);
        return ret;
    }

    @Override
    public void trickleDown(int index, int upto) {

        while( index <= upto ){
            int leftChild = 2*index+1;
            int rightChild = 2*index+2;

            if( leftChild <= upto ){
                int childToSwap;

                if( rightChild > upto ){
                    childToSwap = leftChild;
                }else{
                    childToSwap = ( this.heap[leftChild] < this.heap[rightChild]) ? leftChild : rightChild;
                }

                if( this.heap[index] > this.heap[childToSwap]){
                    int temp = this.heap[index];
                    this.heap[index]=this.heap[childToSwap];
                    this.heap[childToSwap]=temp;
                }else{
                    break;
                }

                index = childToSwap;
            }else{
                break;
            }
        }
    }

    @Override
    public int getRoot() {
        return this.heap[0];
    }

    @Override
    public void heapsort() {

    }

    @Override
    public boolean isFull() {
        return currentIndex == heap.length - 1;
    }
}
