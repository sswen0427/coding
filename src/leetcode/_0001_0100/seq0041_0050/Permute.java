package leetcode._0001_0100.seq0041_0050;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute {

    private List<List<Integer>> lists = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    private void dfs(int first){
        if(first == list.size()){
            lists.add(new ArrayList<>(list));
        }
        for(int i = first; i < list.size(); i++){
            Collections.swap(list, first, i);
            dfs(first + 1);
            Collections.swap(list, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        for(int num : nums){
            list.add(num);
        }
        dfs(0);
        return lists;
    }
}
