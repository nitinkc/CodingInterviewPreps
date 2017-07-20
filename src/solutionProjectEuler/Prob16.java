package solutionProjectEuler;

import java.math.BigInteger;

/*
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 21000?
 */
public class Prob16 {
	public static void main(String[] a) {
		BigInteger c = BigInteger.valueOf(2);
		BigInteger val = c.pow(1000);
		System.out.println(val);		
		System.out.println(sumDigits(val));

		//Done While preparing CAT, in Mumbai!!
//		String val = new String(
//				"10715086071862673209484250490600018105614048117055336074437503883703510511249361224931983788156958581275946729175531468251871452856923140435984577574698574803934567774824230985421074605062371141877954182153046474983581941267398767559165543946077062914571196477686542167660429831652624386837205668069376");
//		// 2^1000 is calculated using Chrom's Scientific calculator app	
	}
	
	public static BigInteger sumDigits(BigInteger s){
		BigInteger sum =BigInteger.ZERO;
		
		while (s != BigInteger.ZERO){
		BigInteger temp = s.remainder(BigInteger.TEN);
		sum = sum.add(temp);
		s = s.divide(BigInteger.TEN);
		}
		return sum;
	}
}
