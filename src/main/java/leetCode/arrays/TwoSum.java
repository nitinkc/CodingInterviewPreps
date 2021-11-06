package leetCode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Created by nichaurasia
 * @create on Sunday, January/24/2021 at 8:09 PM
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // HashMap containing value and its index
        Map<Integer,Integer> map = new HashMap<>();
        int diff = -1;
        int ret[] = new int[2];

        for(int i = 0;i<nums.length;i++){
            diff = target - nums[i];
            if(map.containsKey(diff) && map.get(diff) != i){
                //ret[0] = i;
                //ret[1] = map.get(diff);
                return new int[]{i,map.get(diff)};//When a pair is ensured to be present
            }else{
                map.put(nums[i],i);
            }
        }
        return ret;
    }
}
