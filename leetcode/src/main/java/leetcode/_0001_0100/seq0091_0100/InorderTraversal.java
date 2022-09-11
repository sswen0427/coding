package leetcode._0001_0100.seq0091_0100;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    private List<Integer> list = new ArrayList<>();

    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }
}
