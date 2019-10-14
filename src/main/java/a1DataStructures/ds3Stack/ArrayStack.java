package a1DataStructures.ds3Stack;

import java.util.EmptyStackException;

/**
 * Created by Nitin Chaurasia on 2/9/16 at 10:40 PM.
 */
public class ArrayStack implements Stack{

    private Object[] elements;
    private static final int INITIAL_CAPACITY = 100;
    private int size;

    /* Initialized with the initial capacity */
    public ArrayStack(){
        elements = new Object[INITIAL_CAPACITY];
    }

    /* Initialized with the user defined capacity */
    public ArrayStack(int capacity){
        elements = new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * See the Top of the Stack
     * @return
     */
    @Override
    public Object peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        return elements[size - 1];
    }

    @Override
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();

        //Keep the top emement
        Object top = elements[size - 1];
        //Set the size to null
        elements[size - 1] = null;
        //Bring the pointer down by one
        size = size - 1;

        return top;
    }

    @Override
    public void push(Object element) {
        //if there is one element, put the value in index 1, and increase the size
        elements[size] = element;
        size++;
    }

    @Override
    public int size() {
        return size;
    }
}
