package leetcode._0001_0100.seq0031_0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    private List<List<Integer>> lists = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    private int[] candidates;

    private void dfs(int start, int target){
        if(target == 0){
            lists.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(target - candidates[i] < 0) break;

            if(i > start && candidates[i] == candidates[i-1]) continue;

            list.add(candidates[i]);
            dfs(i+1, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        dfs(0, target);
        return lists;
    }
}
