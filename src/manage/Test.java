package manage;

import java.util.*;


/**
 * This program demonstrates the Random class.
 */

public class Test
{
	public static void main(String a[]){


		String name[] = {"Nitin","Mahak"};
		int[] e = new int[4];
		for(int i=0; i<e.length; i++){
			e[i]= new Scanner(System.in).nextInt();
		}
		
		Arrays.sort(name);
		Arrays.sort(e);
		
		for(String n : name){
			System.out.println(n);
		}
		
		for(int n : e){
			System.out.println(n);	
		}

	}
}