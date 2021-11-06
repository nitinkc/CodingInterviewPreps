package leetCode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Created by nichaurasia
 * @create on Sunday, January/24/2021 at 6:46 PM
 */

public class SpiralCount {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;
        int endRow   = matrix.length-1;
        int endCol   = matrix[0].length-1;

        //Traversing Perimeter of the array
        List<Integer> list = new ArrayList<>();

        while(startRow <= endRow && startCol <= endCol){
            //Traversing the first row
            for(int i=startCol; i<=endCol ;i++){
                list.add(matrix[startRow][i]);//Fixing the start Row
            }

            //Traversing Rightmost Column, excluding the corner element whihc is already covered in above iteration
            for(int i=startRow+1; i<=endRow ;i++){
                list.add(matrix[i ][endCol]);//Fixing the end column
            }

            if(startRow < endRow && startCol < endCol){// Required Check for Rectangular Matrix
                //Traversing the Bottom most row from right to Left
                for(int i=endCol-1; i>=startCol; i--){
                    list.add(matrix[endRow][i]);//Fixing the start Row
                }

                //Traversing the Bottom most right Col to Top
                for(int i=endRow-1; i>startRow; i--){
                    list.add(matrix[i][startCol]);
                }
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return list;
    }
}
