package leetcode._0101_0200.seq0111_0120;

import java.util.Deque;
import java.util.LinkedList;

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

public class Flatten  {
    // 自顶向下
    public void flatten1(TreeNode root) {
        while (root != null){
            if(root.left == null){
                root = root.right;
            }else{
                TreeNode pre = root.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }

    // 后序遍历
    private TreeNode pre = null;
    public void flatten2(TreeNode root) {
        if(root == null) return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    // 后序遍历
    public void flatten3(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root, prev = null;

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.addLast(p);
                p = p.right;
            } else {
                p = stack.peekLast();
                if (p.left != null && p.left != prev) {
                    p = p.left;
                } else {
                    p = stack.pollLast();

                    p.right = prev;
                    p.left = null;

                    prev = p;
                    p = null;
                }
            }
        }
    }

    // 先序遍历 + 栈
    public void flatten4(TreeNode root) {
        if(root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        TreeNode prev = null;

        while (!stack.isEmpty()){
            TreeNode curr = stack.pollLast();
            if(prev != null){
                prev.left = null;
                prev.right = curr;
            }
            TreeNode left = curr.left, right = curr.right;
            if(right != null){
                stack.addLast(right);
            }
            if(left != null){
                stack.addLast(left);
            }
            prev = curr;
        }
    }
}