package udemyJobInterview; /**
 * Created by Nitin Chaurasia on 3/7/15 at 3:28 AM.
 */
import java.util.Stack;

public class Staque {
    public static Stack<Integer> stk1 = new Stack<Integer>();
    public static Stack<Integer> stk2 = new Stack<Integer>();

    public static void main(String[] args){
        enqueue(1); enqueue(21); enqueue(31);
        enqueue(41); enqueue(51); enqueue(61);
        peek();

        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());

        peek();
    }

    public static void enqueue(int val){
        stk1.add(val);
    }

    public static int dequeue() {
        int ret = -1;

        if (stk1.size() == 0) {
            return ret;
        }

        if (stk1.size() == 1) {
            return stk1.pop();
        }
        int size = stk1.size();
        //Take everything out except the last element
        for (int i = 1; i <= size - 1; i++) {
            stk2.push(stk1.pop());
        }

        ret = stk1.pop();

        //Fill Stack 1 back
        for (int i = 1; i <= size - 1; i++) {
            stk1.push(stk2.pop());
        }

        return ret;
    }

    public static void peek(){
        System.out.println(stk1);
    }
}
