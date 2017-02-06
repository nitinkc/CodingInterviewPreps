package dataStructures.linkedlist;

import java.util.Scanner;

public class DriverList {

	public static void main(String[] args) {

		//Polymorphic Call
		ILinkedList list = new MyLinkedList();

        int choice = -1;
        Scanner s = new Scanner(System.in);

        while (choice != 0){
            System.out.println("1: Add a new Node");
            System.out.println("9: Peek");
            System.out.println("0: EXIT");
            System.out.println("Enter a Choice");
            choice = s.nextInt();
            switch (choice){
                case 1 : list.addLast(1);
                    break;
                case 9 : list.peek();
                    break;
                case 0 :
                    return;
                default: System.out.println("Enter a valid number");
                    break;

            }

        }
	}

}
