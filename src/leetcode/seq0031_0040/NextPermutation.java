package leetcode.seq0031_0040;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int i = nums.length-2;
        int j = nums.length-1, k = nums.length-1;
        while (i >= 0 && nums[i] >= nums[j]){
            i--; j--;
        }
        if(i >= 0){
            while (nums[i] >= nums[k]){
                k--;
            }
            int tmp = nums[i];
            nums[i] = nums[k];
            nums[k] = tmp;
        }
        for(i = j,j = nums.length-1; i < j; i++,j--){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
