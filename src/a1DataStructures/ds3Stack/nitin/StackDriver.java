package a1DataStructures.ds3Stack.nitin;

/**
 * Created by Nitin Chaurasia on 4/11/16 at 4:26 PM.
 */


//Write a stack class that has a Pop, push and getMin Methods?
public class StackDriver{
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(12); s.push(24); s.push(36);
        s.push(48); s.push(60); s.push(72);
        s.push(84); s.push(96); s.push(108);
        s.push(120); s.push(132); s.push(144);

        System.out.println(s.pop());
        System.out.println(s.pop());

        System.out.println(s.min());
    }
}