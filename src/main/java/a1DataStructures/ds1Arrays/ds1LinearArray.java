package a1DataStructures.ds1Arrays;

/**
 * Created by nitin.chaurasia on 3/6/2017.
 */
public class ds1LinearArray {
    public static void main(String[] args){

        // INTEGER Array
        //Declaring the Array. Its an Object in Java!
        int[] nums = new int[10];
        for (int i = 0; i< nums.length; i++){
            nums[i] = i*i;
        }
        // Array has a length PROPERTY.
        System.out.println(nums.length);

        for (int a : nums){
            System.out.print(a + "\t");
        }

        System.out.println();

        //STRING ARRAY
        String[] arr = new String[5];

        for(int i = 0; i < arr.length; i++ ){
            arr[i] = "Nitin - " + i*i;
        }

        for(String s : arr){
            System.out.print(s + "\t");
        }
    }
}