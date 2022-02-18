package a1DataStructures.ds3Stack;

/**
 * Created by Nitin Chaurasia on 2/9/16 at 10:38 PM.
 */
public interface Stack {
    boolean isEmpty();
    Object peek();
    Object pop();
    void push(Object element);
    int size();
}
