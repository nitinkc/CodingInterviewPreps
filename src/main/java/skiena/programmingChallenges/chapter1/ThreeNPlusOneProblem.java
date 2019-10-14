package skiena.programmingChallenges.chapter1;

import java.util.Scanner;

/**
 * Created by Nitin Chaurasia on 6/6/15 at 2:49 PM.
 */
public class ThreeNPlusOneProblem {
    public static void main(String args[]){
        Scanner kb = new Scanner(System.in);

        System.out.println("Enter a number");
        int x = kb.nextInt();
        int counter = 0;
        while(x != 1){
            counter++;
            if (x%2 == 0){
                x = x/2;
                System.out.print(x + " ");
            }
            else{
                x = 3*x + 1;
                System.out.print(x + " ");
            }
        }
        System.out.println();
        System.out.println("Final Count = " + counter);
    }
}
