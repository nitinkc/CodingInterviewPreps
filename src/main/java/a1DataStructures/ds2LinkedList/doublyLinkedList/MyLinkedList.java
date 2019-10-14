package a1DataStructures.ds2LinkedList.doublyLinkedList;

public class MyLinkedList implements ILinkedList {

    /**Head always point to the first node of the Linked List
     * Traversal is always done with another node (runner/current)
     */
    Node head = null;

    @Override
    public String toString() {
        if(head == null) {
            return "No List Exist";
        }
        else{
            Node runner = head;
            String ret = null;
            while(runner != null){
                ret = ret + "[Node Address: " + runner + "\tNode Data: " + runner.data + "\tNext Node is at: " + runner.next + "]\n";
            }
            return ret;
        }
    }

    /**
     * View all the elements of the list in a properly formatted String
     * eg: 1 -> 2 -> 3
     */
    @Override
    public void peek() {
        //If Linked List does not exist
        if(head == null){
            System.out.println("Empty List");
            return;
        }

        //If there is only one Node
        if (head.next == null){
            System.out.println("[" + head.data + " ]");
            return;
        }

        Node runner = head;
        System.out.println("[");
        while(runner.next.next != null){//Keeping the last node for the end
            System.out.println(runner.data + " -> ");
        }

        /*Printing the last node*/
        runner = runner.next;
        System.out.println(runner.data + "]");

    }

    /**
     * Returns the size of a linked list
     * @return size
     */
    @Override
    public int size() {
        int size = 0;
        if (head == null){
            return 0;
        }

        Node runner = head;
        while(runner != null){
            size++;
            runner = runner.next;
        }
        return size;
    }

    /**
     * Adding a Node at a given index.
     * After addition the index'th node will be a new node with the given data
     * @param index
     * @param element
     */
    @Override
    public void add(int index, Object element) {
        if (index > size() || index < 0){
            System.out.println("INVALID Index");
            throw new IllegalArgumentException("Give an index in a valid Range");
        }

        if (index == 0){
            addFirst(element);
            return;
        }

        if (index == size()-1){
            addFirst(element);
            return;
        }

        Node runner = head;
        int currIndex = 0;

        //Going to the index - 1'th node and adding a new node
        while(currIndex != index-1){
            currIndex++;
            runner = runner.next;
        }

        //The new Node will be the index'th node of the Linked List
        Node temp = runner.next;
        runner.next = new Node(element, temp);
    }

    /**
     * Adding the node at Beginning. If the Linked List is not initialized, the it will create one.
     * If there are nodes, the at the index 0, it will add.
     * @param element
     */
    @Override
    public void addFirst(Object element) {
        if (head == null){
            head = new Node(element);
        }

        else{
            //Temp is pointing to the head node
            Node temp = head;
            //Point the new node to the list
            head = new Node(element,temp);
        }

    }

    @Override
    public void addLast(Object element) {
        if (head == null) {
            head = new Node(element);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        // Current now points to the LAST node
        current.next = new Node(element, null);
    }

    /**
     * Replacing the value of a given index by element
     * @param index
     * @param element
     */
    @Override
    public void set(int index, Object element) {
        if (head == null || index >= size() || index < 0){
            throw new IllegalArgumentException("LIST DOES NOT EXIST");
        }

        if (head.next == null){
            head.data = element;
        }

        Node runner = head;
        int currIndex = 0;

        // Reach the respective Node
        while(currIndex != index){
            currIndex++;
            runner = runner.next;
        }

        //Change the data of that Node
        runner.data = element;
    }

    /**
     * Clearing the list by setting the head to null and leaving the nodes as Island of Isolation
     */
    @Override
    public void clear() {
        head = null;
    }

    /**
     * Checks if an element exists in the list. If the list is empty, return false
     * @param element
     * @return
     */
    @Override
    public boolean contains(Object element) {
        if (head == null){
            return false;
        }

        Node runner = head;
        while(runner != null){
            if(runner.data == element){
                return true;
            }
            runner = runner.next;
        }

        return false;
    }

    @Override
    public Object get(int index) {
        if (head == null || index >= size() || index < 0){
            throw new IllegalArgumentException("LIST DOES NOT EXIST");
        }

        if (head.next == null){
            return head.data;
        }

        Node runner = head;
        int currIndex = 0;

        //Reaching the respective index
        while(currIndex != index){
            runner = runner.next;
            currIndex++;
        }

        return runner.data;
    }

    @Override
    public Object getFirst() {
        if (head == null) {
            return null;
        }

        return head.data;
    }

    /**
     * Returning the last element of the Linked List
     * @return
     */
    @Override
    public Object getLast() {
        if (head == null){
            return null;
        }

        Node runner = head;
        while(runner.next != null){
            runner = runner.next;
        }

        return runner.data;
    }

    /**
     * Returns the index of an element (First Occurance) if it exists. If it does not, return -1
     * @param element
     * @return
     */
    @Override
    public int indexOf(Object element) {
        if (head == null)
            return -1;

        Node runner = head;
        int index = 0;
        while(runner != null){
            if (runner.data == element){
                return index;
            }
            index++;
            runner = runner.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        if (head == null)
            return -1;

        Node runner = head;
        int index = 0, ret = -1;
        while(runner != null){
            if (runner.data == element){
                ret = index;
            }
            index++;
            runner = runner.next;
        }
        return ret;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object element) {
        return false;
    }

    @Override
    public Object removeFirst() {
        return null;
    }

    @Override
    public Object removeLast() {
        if (this.head == null) {
            System.out.println("List is Already EMPTY");
            return null;
        }

        if (this.head.next == null) {
            head = null;
        }

        Node current = this.head;

        while (current.next.next != null) {
            current = current.next;
        }// Reached to the second last node

        current.next = null;
        return null;
    }

    class Node {
        private Object data;
        private Node next;

        public Node() {
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data){
            this.data = data;
            this.next = null;
        }


    }
}
