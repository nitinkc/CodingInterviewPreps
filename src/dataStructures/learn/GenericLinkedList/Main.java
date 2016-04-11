package dataStructures.learn.GenericLinkedList;

public class Main {

    public static void main(String[] args) {

        MyLinkedList mll = new MyLinkedList();

        //Checking if an element is added in the front
        mll.addFirst("Nitin");//Element 1
        System.out.println("The size of Linked List is " + mll.size());
        mll.peek();

        //mll.add(1,29);
        mll.addLast("The Second Last Element");
        mll.peek();//Checking for the last element

        mll.addFirst("AddFirst");
        //Check if peek works fine
        mll.peek();

        mll.addLast("AddLast");
        mll.addLast(2000);//Testing for non existing element
        mll.peek();//Checking for the last element

        System.out.println(mll.contains("Prashant"));
        mll.indexOf("Nitin");
        mll.clear();
        mll.peek();
    }
}
