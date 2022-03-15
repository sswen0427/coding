package swordpointtooffer.seq11_20;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithTheSameNumberOfZerosAndOnes {
    public int findMaxLength(int[] nums) {
        int counter = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                counter++;
            }else{
                counter--;
            }
            if(!map.containsKey(counter)){
                map.put(counter, i);
            }else{
                res = Math.max(res, i-map.get(counter));
            }
        }
        return res;
    }
}