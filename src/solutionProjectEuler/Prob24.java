package solutionProjectEuler;

public class Prob24 {
	
	static int count=0;

	public static void main(String[] args) {

		String elements = "0123456789";
		long lStartTime = System.nanoTime();
		perm1(elements);
	    System.out.println();
	    
	    long lEndTime = System.nanoTime();
		long difference = lEndTime - lStartTime;
	 
		System.out.println("Elapsed milliseconds: " + difference/1000000);
	}
	//Adapted from "Programming in Java" by Robert Sedgewick
	//http://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
	
	/* Code needs some understanding */
	public  static void perm1(String s) { perm1("", s); }
    private static void perm1(String prefix, String s) {
        int N = s.length();
        if (N == 0 && count<1000000) {//Break the recursive call at 1 millionth entry
        	System.out.print(prefix);
        	count++;
        	System.out.println(" "+count);
        }
        else {
            for (int i = 0; i < N; i++)
               perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
            
        }

    }

}
