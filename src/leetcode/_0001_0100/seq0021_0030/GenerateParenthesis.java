package leetcode._0001_0100.seq0021_0030;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    private List<String> res = new ArrayList<>();

    private void dfs(String curStr, int left, int right){
        if(left == 0 && right == 0){
            res.add(curStr);
            return;
        }
        if(left > right) return;
        if(left > 0) dfs(curStr + "(", left-1, right);
        if(right > 0) dfs(curStr + ")", left, right-1);
    }

    public List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return res;
    }

}
