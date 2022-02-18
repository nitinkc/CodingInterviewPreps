package ArraysProblems;

import java.util.Arrays;

public class EvenFirstOddNext {
    public static void main(String[] args) {
        int[] a = {1,3,5,7,9,11,2,4,5,6};
        putEvenFirst(a);
        System.out.println(Arrays.toString(a));
    }

    private static void putEvenFirst(int[] arr){
        //Utilize the fact that an array can be traversed both ways
        int frontIndex = 0, backIndex = arr.length-1;

        while (frontIndex < backIndex){
            //If front element is already zero, go forward else swap
            if(arr[frontIndex] %2 == 0){
                frontIndex++;
            }else {
                //SWAP
                int temp = arr[frontIndex];
                arr[frontIndex] = arr[backIndex];
                arr[backIndex] = temp;
                backIndex--;
            }
        }
    }
}
