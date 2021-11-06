package manage;

/**
 * Created by nitinc on 3/13/2015.
 */
public class RotateArray {
    public static void main(String args[]){
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        rotatedArray(mat, 5);
    }

    public static void rotatedArray(int[][] arr, int size){

        System.out.println("BEFORE ROTATION");
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(i + "" + j + "    ");
            }
            System.out.println();
        };

        /*
        Beginning with a square matrix of size 1 and then 2 and then 3, the pattern that was observed
        was that the position of i is interchanged and that of j as well. The values of j comes down from size
        to zero.
         */
        System.out.println("AFTER ROTATION");
        //Rotate the Array by 90 degrees
        for (int i = 0; i < size ; i++) {
            for (int j = size-1; j >= 0; j--) {
                System.out.print(j + "" + i + "    ");
            }
            System.out.println();
        }
    }
}
