package manage;

import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        //To carry huge values
        BigInteger sum= BigInteger.ZERO;
        if (n >= 1 && n <= 2*Math.pow(10,6)){
            for (int i=1; i <= n; i++){
                sum = sum.add(BigInteger.valueOf(i).pow(i));
            }
        }
        String last10 = "";
        
        for (int i = 1; i <= 10; i++){
            last10 = last10 + sum.mod(BigInteger.TEN).toString();
            sum = sum.divide(BigInteger.TEN); 
        }

        String rev = new StringBuffer(last10).reverse().toString();
        System.out.println(Long.valueOf(rev));
    }
}