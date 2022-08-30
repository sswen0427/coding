package leetcode._0001_0100.seq0071_0080;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private List<List<Integer>> lists = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    private int[] nums;

    private void dfs(int index){
        if(index == nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        dfs(index + 1);
        list.remove(list.size()-1);
        dfs(index + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return lists;
    }
}
