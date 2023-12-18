package leetCode.arrays;

/**
 * @Author Created by nichaurasia
 * @create on Sunday, January/24/2021 at 10:50 PM
 */

public class LargestNumber {
    public String largestNumber(int[] nums) {
        //Placeholder array: index = number, value = repeatition
        int[] arr = new int[10];

        for(int i=0;i<nums.length;i++){
            int currentNum = nums[i];
            if(currentNum < 10){
                arr[currentNum] = arr[currentNum]+1;
            }else{
                do{
                    int num = currentNum/10;
                    currentNum = currentNum%10;
                    arr[num] = arr[num]+1;
                }while(currentNum >= 10);
                arr[currentNum] = arr[currentNum]+1;//Taking care of the last digit - Off by one error
            }
        }

        String ret = "";
        for(int i=arr.length-1;i>=0;i--){
            for(int j=1;j<=arr[i];j++){
                ret = ret+ i;
            }
        }
        return ret;
    }
}