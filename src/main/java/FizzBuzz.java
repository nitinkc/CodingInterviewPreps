import java.util.Scanner;

/**
 * @author nitin
 * Based on lecture 21,22 of the Udemy Course
 */
public class FizzBuzz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int i;
		for(i=1;i<=num; i++){
			if (i%3==0 && i%5==0)
				System.out.println("FizzBuzz");
			else if(i%3==0)
				System.out.println("Fizz");
			else if(i%5==0)
				System.out.println("Buzz");
			else
				System.out.println(i);
		}
	}
}