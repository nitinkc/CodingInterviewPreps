package a1DataStructures.ds1Arrays;

/**
 * Created by nitin.chaurasia on 2/20/2017.
 */
public class ArrayList {
    public static void main(String args[]){
        int nums[];

        for (int i = 0; i< 10; i++){
            nums[i] = i*i;
        }

        for (int a : nums){
            System.out.println(a);
        }
    }
}
