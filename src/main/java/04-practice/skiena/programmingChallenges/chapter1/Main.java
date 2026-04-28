package skiena.programmingChallenges.chapter1;

/**
 * Created by Nitin Chaurasia on 6/6/15 at 4:08 PM.
 */
/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

class Main{

    public static void main(String[] args) throws Exception {
        final String IN_FILENAME = "110101.inp";
        final String OUT_FILENAME = "110101.out";

        File input = new File(IN_FILENAME);
        /* Reading input from the input file */
        Scanner in = new Scanner(input);

        /* Preparing the output*/
        PrintWriter out = new PrintWriter(new FileWriter(OUT_FILENAME, true));

        // while there is some input to read
        while (in.hasNextInt()) {
            int i = in.nextInt(),
                    j = in.nextInt(),
                    from = Math.min(i, j),
                    to = Math.max(i, j),
                    max = 0;

            // loop through all the numbers
            // and find the biggest cycle
            for (int n = from; n <= to; n++) {
                max = Math.max(max, cycleLength(n));
            }
            out.println("Nitin");
            out.println(i + " " + j + " " + max);
        }
    }

    static int cycleLength(int x){
        int counter = 0;
        while(x != 1){
            counter++;
            if (x%2 == 0){
                x = x/2;
            }
            else{
                x = 3*x + 1;
            }
        }
        return counter;
    }
}