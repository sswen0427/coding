package swordpointtooffer.seq31_40;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder3 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean flag = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
                if(flag){
                    list.add(node.val);
                }else {
                    list.add(0, node.val);
                }
            }
            flag = !flag;
            lists.add(list);
        }
        return lists;
    }
}
