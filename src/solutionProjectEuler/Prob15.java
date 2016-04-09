package solutionProjectEuler;
import java.math.BigInteger;
public class Prob15 {

	/**
	 * @param args
	 * Starting in the top left corner of a 22 grid, 
	 * there are 6 routes
	 *  (without backtracking) to the bottom right corner.
				
			 How many routes are there through a 2020 grid?
	 */
	public static void main(String[] args) {
		// BYJU's method .... 20 zeroes and 20 ones--> 
		//20 Rows and 20 Columns and the move is either Hori.
		//or Vertical. Thus 40!/(20!*20!)
		
		BigInteger f = fact(BigInteger.valueOf(40));
		BigInteger g = fact(BigInteger.valueOf(20));
		BigInteger result = f.divide(g.multiply(g));//f/(g*g)
		
		System.out.println(result);
	}
	
	//Function adapted from problem 20
	static BigInteger fact(BigInteger n){
		
		BigInteger fact=n;
		 if (n == BigInteger.ZERO){
			 return BigInteger.ONE;
		 }//end if
		 else{//Recusrive fact = fact*calcFact(n-1);
			 fact = fact.multiply(fact(n.subtract(BigInteger.ONE)));
		 }
		return fact;
	}
}
