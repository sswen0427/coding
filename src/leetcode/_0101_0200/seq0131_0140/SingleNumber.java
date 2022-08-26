package leetcode._0101_0200.seq0131_0140;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums){
            res ^= num;
        }
        return res;
    }
}
