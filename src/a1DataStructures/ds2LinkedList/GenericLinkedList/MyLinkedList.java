package a1DataStructures.ds2LinkedList.GenericLinkedList;

/**
 * Created by Nitin Chaurasia on 10/3/14.
 * As part of Learning to solve Cracking the coding Interview
 */
public class MyLinkedList implements NitinLinkedList{

    Node head = null;//Head object pointing to NULL Initially

    /* Add any element in the middle of the Linked list as specified by the index */
    public void add(int index, Object element) {
        Node newNode = new Node(element);
        Node curr = head;
        if(index > size()){
            System.out.println("Invalid index");
        }
        else if(index == 0){//the first element is at index ZERO
            addFirst(element);
        }
        else if(index == size()-1){//reaching at the end
            addLast(element);
        }
        else{
            for(int i=0 ;i < index ;i++){
                curr = curr.next;
            }
            curr.next = newNode;//newNode is assigned
            newNode.next = curr.next;//pointing the newNode to the next node, inserting itself
        }
    }

    /* Add an element in the beginning of the List */
    public void addFirst(Object o) {
        Node newNode = new Node(o);
        //If the list is already created, point the head to the new Node
        if(head != null)
            newNode.next = head;//head should point to the new node created
        //First node creation
        head = newNode;//Copying info of new Node to head
    }

    /* Add an element to the end of the list */
    public void addLast(Object o) {
        Node newNode = new Node(o);
        if (head == null) {//If the List is first created
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null)//call getLast
                curr = curr.next;
            curr.next = newNode;
        }
    }

    /* Deleting the entire List */
    public void clear() {//Remove all the elements OR just point Head to NULL
        Node prev = head;
        while (head != null){//Continue moving head and deleting previous node
            head = prev.next;
            prev = null;
        }
        head =null;//Finally Remove the head node as well

    }

    /* Checks if a particular element exists or not*/
    public boolean contains(Object o) {
        Node curr = head;
        while (curr != null) {
                if (curr.o == o) {//Comparing the element
                    return true;
            }
        }
        return false;
    }

    /* Getting the element from a particular index */
    public Object get(int index) {
        Node curr = head;
        if(index < 0 || index >= size()){//checks if the list is empty
            System.out.println("Invalid Index");
            return null;
        }
        else{
            for(int i = 0; i <= index; i++){
                curr = curr.next;
            }
            return curr.o;
        }
    }//end get()

    /* Getting the first element */
    public Object getFirst() {
        if(head!=null)
            return head.o;
        else
            return null;
    }//end getFirst()

    /* Getting the last element of the list*/
    public Object getLast() {
        Node curr = head;
        if(curr == null)
            return null;
        else {//iterate through the list (May make a function)
            while (curr.next != null) {
                curr = curr.next;
            }
            return curr.o;
        }
    }//end getLAst()

    /* Deleting the entire List*/
    public int indexOf(Object o) {
        int counter = -1;//if element is not there, return -1
        if(contains(o) == true){//check is element is there, and then proceed
            Node curr = head;
            while (curr != null) {
                ++counter;
                curr = curr.next;
                }
            return counter;
        }
        else
        return counter;
    }

    /* Getting the last index of the List */
    public int lastIndexOf(Object o) {
        return size()-1;
    }

    /* Remove a particular element at Index */
    public Object remove(int index) {
        Node curr = head;
        if(index < 0 || index >= size())
        {
            System.out.println("Invalid index");
            return null;
        }
        else{
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            curr = curr.next.next;//
            return curr.o;
        }

    }

    /* Deleting the entire List*/
    public boolean remove(Object o) {

        return false;
    }

    /* Deleting the entire List*/
    public Object removeFirst() {

        return null;
    }

    /* Deleting the entire List*/
    public Object removeLast() {
        return null;
    }

    /* Deleting the entire List*/
    public Object set(int index, Object element) {
        return null;
    }

    /* Returns the size of the Linked List */
    public int size() {
        int counter = 0;
        Node curr = head;

        while(curr != null){
            counter++;
            curr = curr.next;
        }
         return counter;
    }//end size()

    /* Looking into the entire list */
    public void peek() {
        Node curr = head;
        if (curr == null) {
            System.out.println("Empty List");
        } else {//Print only if there are some elements
            while (curr != null) {
                System.out.print(curr.o + ", ");
                curr = curr.next;
            }
            System.out.println();
        }
    }//end peek()
}//end CLASS MyLinkedList