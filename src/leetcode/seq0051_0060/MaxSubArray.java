package leetcode.seq0051_0060;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for(int x : nums){
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
