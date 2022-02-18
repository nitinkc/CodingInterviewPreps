package solutionProjectEuler;

public class Prob1 {

	/**
	 * @param args
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
	   Find the sum of all the multiples of 3 or 5 below 1000.
	 */
	public static void main(String[] args) {
		int mulOf3, sum3, mulOf5, sum5,mulOf15, sum15, finalSum, i,j,k;
		mulOf3=0;
		mulOf5=0;
		mulOf15=0;
		sum3=0;
		sum5=0;
		sum15=0;
		
		//all the multiples of 3
		for (i=1;i<=333;i++){
			mulOf3 = mulOf3 +3;
			sum3 = sum3 + mulOf3;
		}
		
		//all the multiples of 5
		for (j=1;j<200;j++){
			mulOf5 = mulOf5 + 5;
			sum5 = sum5 + mulOf5;
		}
		
		for (k=1;k<=66;k++){
			mulOf15 = mulOf15 + 15;
			sum15 = sum15 + mulOf15;
		}
	finalSum = sum3 + sum5 - sum15;
	System.out.println("finalSum : " + finalSum);
	System.out.println(sum3);
	System.out.println(sum5);
	System.out.println(sum15);
	}

}
