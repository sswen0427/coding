package leetcode._0001_0100.seq0021_0030;
import java.util.PriorityQueue;

public class MergeKLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode work = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));

        for(ListNode node : lists){
            if(node != null){
                queue.add(node);
            }
        }
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            ListNode next = node.next;
            if(next != null){
                queue.add(next);
            }
            work.next = node;
            work = work.next;
        }
        work.next = null;
        return head.next;
    }
}
