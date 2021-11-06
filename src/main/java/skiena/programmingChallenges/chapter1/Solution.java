package skiena.programmingChallenges.chapter1;

/**
 * Created by Nitin Chaurasia on 6/19/15 at 2:33 AM.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            System.out.print(e);
        }

        int t = 0;
        try {
            t = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(t);


        while (t-- != 0) {
            String n = null;
            try {
                n = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(n);
            //if (n == (Byte)n){

        }
    }
}