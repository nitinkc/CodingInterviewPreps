package a2utilities;

import java.util.*;

public class Sets {
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList(
                "Harry", "Hermione", "Ron",
                "Harry", "Ron", "Ron", "Remus"
        );

        //treeSet(namesList);
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.peek());  // Output: 3

        while (!stack.empty()) {
            System.out.println("Popped element: " + stack.pop());
        }

    }

    private static void treeSet(List<String> namesList) {
        Set<String> treeSet = new TreeSet<>(Comparator.reverseOrder());
        treeSet.addAll(namesList);

        System.out.println(treeSet);
    }
}
