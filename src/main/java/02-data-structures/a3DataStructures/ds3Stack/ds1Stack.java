package a3DataStructures.ds3Stack;

import java.util.Iterator;
import java.util.Stack;

public class ds1Stack {
    public static void main(String[] args) {

        // Stack has List Interface implementation
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < 10; i++) {
            s.push(i * i);
        }

        System.out.println(s.peek());

        Iterator<Integer> itr = s.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
