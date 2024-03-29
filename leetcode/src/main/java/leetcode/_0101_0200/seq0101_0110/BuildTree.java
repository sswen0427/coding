package leetcode._0101_0200.seq0101_0110;

import java.util.HashMap;
import java.util.Map;

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

class BuildTree {

    private Map<Integer, Integer> indexMap;

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if(preorder_left > preorder_right) return null;

        int preorder_root = preorder_left;
        int inorder_root = indexMap.get(preorder[preorder_root]);

        TreeNode root = new TreeNode(preorder[preorder_root]);

        int size_left_subtree = inorder_root - inorder_left;
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);

        return root;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n-1, 0, n-1);
    }
}
