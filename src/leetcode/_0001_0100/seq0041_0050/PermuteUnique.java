package leetcode._0001_0100.seq0041_0050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {

    private List<List<Integer>> lists = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    private int[] nums;

    private boolean[] used;

    private void dfs(int depth){
        if(depth == nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1])   continue;
            list.add(nums[i]);
            used[i] = true;
            dfs(depth+1);
            used[i] = false;
            list.remove(list.size() - 1);
        }

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        used = new boolean[nums.length];
        dfs(0);
        return lists;
    }
}
