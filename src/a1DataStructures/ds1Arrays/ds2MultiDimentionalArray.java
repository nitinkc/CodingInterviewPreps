package a1DataStructures.ds1Arrays;

/**
 * Created by nitin.chaurasia on 2/20/2017.
 */
public class ds2MultiDimentionalArray {
    public static void main(String[] args) {

        // Declaring a Rectangular Matrix
        String arr[][] = new String[6][7];
        int row = arr.length;// Row = 6
        int col = arr[0].length; // Columns = 7

        //Printing the Matrix using FOR Loop
        for (int i = 0; i < row; i = i + 1) {
            for (int j = 0; j < col; j = j + 1) {
                arr[i][j] = i + "" + j + " ";
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        //For Each loop for Multi dimensional Array
        for (String a[] : arr) {
            for (String b : a) {
                System.out.print(b + "\t");
            }
            System.out.println();
        }

        //Declaring a 3X3 Square matrix
        String arr2[][] = new String[3][3];
        for (int i = 0; i < arr2[0].length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = "-" + i + "_" + j;
            }
        }

        //For Each loop for Multi dimensional Array
        for (String a1[] : arr2) {
            for (String b : a1) {
                System.out.print(b + "\t");
            }
            System.out.println();
        }
    }
}
