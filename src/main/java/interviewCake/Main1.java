package interviewCake;

import java.util.Random;

public class Main1 {

    public static void main(String[] args) {
        int[] a = generateRandomArrayOneD();
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + ",");
        System.out.println();

        a = function(a);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + ",");
        System.out.println();
    }//end main


    static int[] function(int[] a) {
        int[] b = new int[a.length];
        int count = 0;
        for (int i = 0; i < a.length; i++) {//parameter in array and method in string
            if (a[i] == 0)
                count++;
        }//end for

        for (int i = 0; i < count; i++)//Put zeroes in the beginning
            b[i] = 0;

        int bCounter = count;
        int aCounter = 0;
        for (int i = 0; i < (a.length); i++) {
            if (a[i] == 0) {
                aCounter++;//skip the zero
            } else {
                b[bCounter++] = a[aCounter];//else copy the current a into current b
                aCounter++;
            }
        }//end for
        return b;
    }

    public static int[] generateRandomArrayOneD() {
        int row = generateRandomNumber(10, 1);

        int[] arr = new int[row];

        for (int i = 0; i < row; i++) {
            arr[i] = generateRandomNumber(10, -10);
        }
        return arr;
    }

    public static int generateRandomNumber(int max, int min) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}



