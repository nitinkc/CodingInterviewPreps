/**
 * Problem 21 of Project Eulers
 * 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n 
 * which divide evenly into n).
If d(a) = b and d(b) = a, where a ??? b, then a and b are an amicable pair and 
each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71
  and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
 */
package solutionProjectEuler;

/**
 * @author nitin
 * Date : Aug 27, With Mahak, after NO
 *
 */
public class Prob21 {

	public static void main(String[] args) {

		int num1, num2, sum=0;
		
		for (int i=1;i<10000;i++){
			num1 = findFactorSum(i);//284 = d(220) 
			num2 = findFactorSum(num1);//220 = d(284)
			
			if (i == num2){
				if(num1!=num2){//excluding the number whose factors add upto 
					//the same number
				System.out.println("Amicable number pair "
									+ num1+" " +num2);
				sum = sum + i + num2;
			}	
			}
		}
		System.out.println("The sum is : " + sum/2);//Each pair is repeated twice
		//because of commutativity
	}
	
	public static int findFactorSum(int n){
		int sum=1; //to include 1 as the factor, to reduce the for loop by half
		for (int i=2;i<=n/2;i++){
			if(n%i == 0){
			sum = sum + (n/i);
			}
		}
		return sum;	
	}
}
