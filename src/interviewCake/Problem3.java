package interviewCake;

/**
 * Created by nitin on 2/17/15.
 */
public class Problem3 {
    public static void main (String[] args){
        int[] test1 = {1,2,3};
        int[] test2 = {1,2, 3, -4, -5, -6};
        System.out.println(highest_product(test1));
    }

    public static int highest_product(int[] array_of_ints){
        int temp1 = array_of_ints[0];
        int temp2 = array_of_ints[1];
        int temp3 = array_of_ints[2];

        int prod = temp1*temp2*temp3;

        for (int i = 3; i < array_of_ints.length; i++) {


        }
        return prod;

    }
}
