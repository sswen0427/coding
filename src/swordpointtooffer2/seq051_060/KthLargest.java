package swordpointtooffer2.seq051_060;

import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> queue;

    private int k;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.k = k;

        for (int num : nums){
            queue.add(num);
        }
    }

    public int add(int val) {
        queue.add(val);
        while (queue.size() > k){
            queue.poll();
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
