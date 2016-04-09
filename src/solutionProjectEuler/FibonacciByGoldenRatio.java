package solutionProjectEuler;

public class FibonacciByGoldenRatio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long t=0;
		double goldenRatio = (1 + Math.sqrt(5))/2;
		double conjugateGoldenRatio = (1 - Math.sqrt(5))/2;
		System.out.println("Golden Ratio is " + goldenRatio);
		System.out.println("The Conjugate of Golden Ratio is "+conjugateGoldenRatio);
		
		for (int i=1;i<=50;i++){ //ith term = phi - phiBar/sqrt 5
			t = (long)((Math.pow(goldenRatio,i) - Math.pow(conjugateGoldenRatio,i))/(Math.sqrt(5))); 
			//System.out.println(i);
			System.out.println("Term "+i + " " +t);
		}			
	}
}