	/*
	 * Nitin Chaurasia 
	 * Aug 21, 2:36 AM
	 * A simple use of BigInteger to calculate the value of factorial 100!!
	 * A step towards solving a problem sum of digits of Factorial 100 of Project Euler 
	 * https://projecteuler.net/problem=20
	 */

package solutionProjectEuler;

import java.math.BigInteger;
import java.util.Scanner;

public class Prob20 {

		public static void main(String[] args) {

			//set timer
			long time = System.currentTimeMillis();
			//Read the user input
			Scanner kb = new Scanner(System.in);
			System.out.println("Enter a number to find a factorial of");

			//n is int but Type conversion issues forced n to be BigInt
			BigInteger n = kb.nextBigInteger();
			
			//fact stores the value of Factorial
			BigInteger fact = calcFactorial(n);
			System.out.println(fact);
			
			System.out.println("The sum of digits is "+getSum(fact));
			
			//sysout the time in ms
			System.out.println((System.currentTimeMillis() - time) + "ms");
			kb.close();
			
		}
		
		/*
		 * Nitin Chaurasia 
		 * Aug 21, 5:01 AM
		 * BigInteger Learning
		 * Project Euler Problem Solution
	*/
		static BigInteger calcFactorial(BigInteger n){
			
			BigInteger fact=n;
			 if (n == BigInteger.ZERO){
				 return BigInteger.ONE;
			 }//end if
			 else{//Recusrive fact = fact*calcFact(n-1);
				 fact = fact.multiply(calcFactorial(n.subtract(BigInteger.ONE)));
			 }
			return fact;
		}
		
		static int getSum(BigInteger n){
			
			int digitSum=0;	
			
			//Making the big int split into individual characters to manipulate the 
			//sum
			char temp[] = n.toString().toCharArray();
			
			//Iterate through the array and keep adding the numeric values
			//The ascii value of an integer is 48 more than its absolute! 
			for(int i=0;i<temp.length;i++)
				//The Ascii Chart int 48 = char 0
				//Thus a constant difference of 48 to get the numeric value
				 digitSum += (Character.valueOf(temp[i])-48);
			
			return digitSum;
		}

	}
