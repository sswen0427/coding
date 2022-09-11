package leetcode._0101_0200.seq0131_0140;

import java.util.ArrayList;
import java.util.List;

public class Partition {

    private String str;

    List<List<String>> solutions = new ArrayList<>();

    List<String> list = new ArrayList<>();

    private boolean isValid(int start, int end){
        while (start < end){
            if(str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    private void dfs(int start){
        if(start == str.length()){
            solutions.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < str.length(); i++){
            if(isValid(start, i)){
                list.add(str.substring(start, i+1));
                dfs(i+1);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        str = s;
        dfs(0);
        return solutions;
    }
}
