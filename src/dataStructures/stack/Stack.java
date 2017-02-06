package dataStructures.stack;

/**
 * Created by Nitin Chaurasia on 2/9/16 at 10:38 PM.
 */
public interface Stack {
    public boolean isEmpty();
    public Object peek();
    public Object pop();
    public void push (Object element);
    public int size();
}
