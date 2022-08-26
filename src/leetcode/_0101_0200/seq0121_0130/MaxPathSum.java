package leetcode._0101_0200.seq0121_0130;


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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 public class MaxPathSum {

    private int maxPathSum = Integer.MIN_VALUE;

    private int dfs(TreeNode node){
        if(node == null) return 0;

        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);
        maxPathSum = Math.max(maxPathSum, left + right + node.val);
        return node.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPathSum;
    }
}
