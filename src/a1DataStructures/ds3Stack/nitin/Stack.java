package a1DataStructures.ds3Stack.nitin;

import java.util.ArrayList;
import java.util.Collections;


class Stack{
    ArrayList<Integer> stack = new ArrayList<Integer>();
    int top = stack.size() - 1;

    public void push(int value){
        //When the stack is enmpty
        if (stack.size() == 0){
            stack.add(value);
            top = stack.size() - 1;
        }

        //if stack has elements already
        stack.add(value);
        top = stack.size() - 1;
    }

    public int pop(){
        if (top == 0)
            throw new NullPointerException();

        int ret = stack.get(top);
        top = top - 1;
        return ret;
    }

    public int min(){
        // O(n) extra space complexity
        ArrayList<Integer> temp = stack;

        Collections.sort(temp);
        // O(nlogn) operation

        return temp.get (0);
    }
}