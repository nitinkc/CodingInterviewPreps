package solutionProjectEuler;

public class Prob5 {

	/**
	 * @param args
	 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

       What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	 */
	public static void main(String[] args) {
		//manually 2 2 2 2 3 3 5 7 11 13 17 19 will solve the case (LCM of 1,2....20)
		int val = 16*9*5*7*11*13*17*19;
		System.out.println(val);

	}

}
