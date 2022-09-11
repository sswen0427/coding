package leetcode._0001_0100.seq0081_0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

    private List<List<Integer>> lists = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    private int[] nums;

    private void dfs(int startIndex){
        lists.add(new ArrayList<>(list));
        for(int i = startIndex; i < nums.length; i++){
            if(i > startIndex && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            dfs(i+1);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        dfs(0);
        return lists;
    }
}
