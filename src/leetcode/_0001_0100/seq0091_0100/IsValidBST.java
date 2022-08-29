package leetcode._0001_0100.seq0091_0100;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class IsValidBST {

    private boolean dfs(TreeNode node, long left, long right){
        if(node == null) return true;
        if(node.val <= left || node.val >= right) return false;
        return dfs(node.left, left, node.val) && dfs(node.right, node.val, right);
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
