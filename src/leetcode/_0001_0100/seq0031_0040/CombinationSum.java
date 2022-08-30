package leetcode._0001_0100.seq0031_0040;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private List<List<Integer>> lists = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    private int[] candidates;

    private void dfs(int start, int remain){
        if(remain < 0) return;
        if(start >= candidates.length) return;

        if(remain == 0){
            lists.add(new ArrayList<>(list));
            return;
        }

        dfs(start + 1, remain);

        list.add(candidates[start]);
        dfs(start, remain - candidates[start]);
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        dfs(0, target);
        return lists;
    }
}
