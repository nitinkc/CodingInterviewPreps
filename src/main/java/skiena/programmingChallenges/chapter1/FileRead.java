package skiena.programmingChallenges.chapter1;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Nitin Chaurasia on 6/8/15 at 2:05 AM.
 */
public class FileRead {
    public static void main(String args[]) {

        final String IN_FILENAME = "110101.inp";
        final String OUT_FILENAME = "110101.out";

        File input = new File(IN_FILENAME);
        /* Reading input from the input file */
        try {
            Scanner in = new Scanner(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /* Preparing the output*/
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(OUT_FILENAME, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("Nitin");
        out.println("Chaurasia");
    }
}
