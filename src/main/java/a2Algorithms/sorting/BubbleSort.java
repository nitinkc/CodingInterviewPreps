package a2Algorithms.sorting;

/**
 * @author nitin
 *
 */
public class BubbleSort {

static final int N = 5; //defining the size of the array
static final int MAX = 100;//Random numbers less than MAX
	
	public static int[] A = new int[N]; //Array will have N elements, indexed from 0 to N-1

	public static void main(String[] args) {

		System.out.println("Values before Sorting:");
		printArray(randomArray()); //Initialize the Array with some Random Values
									//and Print the Array

		//Sort the Array (Insertion sort)
		bubbleSort(A);
		
		System.out.println("array after Sorting");
		printArray(A);
	}
	
	//Begin insertion sort (Sorts in place)
	public static void bubbleSort (int []A) {

		for (int i = 0; i < A.length -1 ; i++) {
			for (int j = 0; j < i; j++) {
				//if (A[j] <= A[i]) {// Reverse Sort
				if (A[j] >= A[i]) {// Natural Sort
					//swap();
					int temp = A[j];
					A[j] = A[i];
					A[i] = temp;
				}
			}
		}// END BUBBLE SORT
	}


	//Print the Array.
	public static void printArray(int[] B){
		for (int i=0;i<B.length;i++)//for each loop
			System.out.print(B[i] + ", ");//off by one bug (Extra Comma)
		System.out.println();
	}
	 
	//Generate Array
	public static int[] randomArray(){
		for (int i=0;i<A.length;i++){
			A[i] = (int)(Math.random()*MAX);//Random numbers below 100
			//Math.random() returns number between 0 and 1
		}
		return A;
	}
}
