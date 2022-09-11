package leetcode._0201_0300.seq0231_0240;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LowestCommonAncestor2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void getPath(TreeNode root, TreeNode end, List<TreeNode> path){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root, prev = null;
        while (p != null || !stack.isEmpty()){
            if(p != null){
                stack.addLast(p);
                path.add(p);
                if(p == end) return;
                p = p.left;
            }else {
                p = stack.peekLast();
                // 右孩子不为空且右孩子尚未访问
                if(p.right != null && p.right != prev){
                    p = p.right;
                    stack.addLast(p);
                    path.add(p);
                    if(p == end) return;
                    p = p.left;
                }else {
                    p = stack.pollLast();
                    path.remove(path.size()-1);
                    prev = p;
                    p = null;
                }
            }
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>(), path2 = new ArrayList<>();
        getPath(root, p, path1);
        getPath(root, q, path2);

        int n = Math.min(path1.size(), path2.size());
        TreeNode last = null;
        for(int i = 0; i < n; i++){
            if(path1.get(i) != path2.get(i)) return last;
            last = path1.get(i);
        }
        return last;
    }

    /*
    *                   3
    *            5            1
    *      6          2     0   8
    * null  null    7   4
    *
    * */
    private static TreeNode root, p , q;
    private static void init(){
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node3.left = node5; node3.right = node1;
        node5.left = node6; node5.right = node2;
        node1.left = node0; node1.right = node8;
        node2.left = node7; node2.right = node4;
        root = node3;
        p = node5;
        q = node1;
    }

    public static void main(String[] args) {
        init();
        LowestCommonAncestor2 ancestor2 = new LowestCommonAncestor2();
        ancestor2.lowestCommonAncestor(root, p, q);
    }
}













