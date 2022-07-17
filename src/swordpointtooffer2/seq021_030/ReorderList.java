package swordpointtooffer2.seq021_030;

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

public class ReorderList {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null) return;
        // step1 : split the list to two part
        ListNode dummy1 = new ListNode(-1, head);
        ListNode slow = dummy1, quick = head;
        while(quick.next != null && quick.next.next != null){
            quick = quick.next.next;
            slow = slow.next;
        }
        if(quick.next != null) slow = slow.next;

        // step2 : reverse the second part
        ListNode dummy2 = new ListNode(-1, slow.next);
        ListNode dummy3 = new ListNode(-1);
        slow.next = null;
        while(dummy2.next != null){
            ListNode node = dummy2.next;
            dummy2.next = node.next;
            node.next = dummy3.next;
            dummy3.next = node;
        }


        // step3 : merge the two list
        ListNode work1 = head;
        while(dummy3.next != null){
            ListNode node = dummy3.next;
            dummy3.next = node.next;
            node.next = work1.next;
            work1.next = node;
            if(node.next == null){
                node.next = dummy3.next;
                dummy3.next = null;
            }else{
                work1 = work1.next.next;
            }
        }
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reorderList.reorderList(node1);
    }
}
