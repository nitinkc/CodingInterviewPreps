package a1DataStructures.ds3Stack;

/**
 * Created by Nitin C on 2/8/2016.
 */
public class Driver {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);

        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

        stack.push("Nitin");
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

        stack.push("test1");
        stack.push("test2");
        stack.push("test3");
        System.out.println(stack.size());

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());

        System.out.println(stack.peek());

    }
}
