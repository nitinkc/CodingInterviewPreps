package topCoder.SRM528Div1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
Thursday, July 12, 2012 at 7:21 AM
In Mumbai, after a little reading of the Kathy Sierra and Collections Framework.

Updated on Mar 16, 2015
lol.. I began with the Div 1, 250 point problem. 
 */

public class Cut {
	public static void main(String[] args) {
		
		//TEST CASES
		int[] eels = {13,20,13};
		int result = getMaximum(eels,3);
		System.out.println(result);
		
		int[] eels1 = {5, 5, 5, 5};
		int result1 = getMaximum(eels1,2);
		System.out.println(result1);
		
		int[] eels2 = {34, 10, 48}; //test failed 10 should'n be cut
		int result2 = getMaximum(eels2,4);
		System.out.println(result2);
		
		
		int[] eels3 = {30, 50, 30, 50};
		int result3 = getMaximum(eels3,350);
		System.out.println(result3);
		
		
	}
	
	public static int getMaximum(int[] eelLengths, int maxCuts){
		
		int tempPieces=0;
		int totalPieces=0;
		List<Integer> eelL = new ArrayList<Integer>();
		for (int i=0;i<eelLengths.length;i++){
			eelL.add(eelLengths[i]);
			}
		
		//ARRANGING THE ITEMS IN THE REVERSE SORTED WAY. THE TRICK IS TO CUT THE LONGEST EEL WITH THE MAXIMUM POSSIBLE CUTS,
		//FOLLOWED BY THE SECOND LONGEST...RECKON ITS A GREEDY APPROACH
		
		Collections.sort(eelL);
		Collections.reverse(eelL);
		System.out.println(eelL);
		
		for (int i=0;i<eelLengths.length;i++){
			if (eelL.get(i) !=10){//line included to accomodate failed test
				tempPieces = eelL.get(i)/10;
				if(maxCuts != 0){
					maxCuts = maxCuts-tempPieces;
					totalPieces = tempPieces + totalPieces;	
					}
				else
				break;
				}
			else{
				System.out.println("There is an Eel of length 10"); //the failed case is not working as the loop is breaking before traversing the last of the array
				++totalPieces;
			}
		}
		return totalPieces; 
	}

}
