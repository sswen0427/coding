package leetcode._0401_0500.seq0471_0480;

import java.util.PriorityQueue;

public class MedianSlidingWindow {
    private final PriorityQueue<Long> small = new PriorityQueue<>();
    private final PriorityQueue<Long> big = new PriorityQueue<>((o1, o2) -> -Long.compare(o1, o2));
    private double get(int k){
        if(k % 2 == 1) return small.peek();
        else return (small.peek() + big.peek()) / 2.0;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            small.add(new Long(nums[i]));
        }
        for(int i = 0; i < k / 2; i++){
            big.add(small.poll());
        }
        double[] res = new double[nums.length - k + 1];
        res[0] = get(k);
        for(int i = k; i < nums.length; i++){
            Long left = new Long(nums[i-k]);
            Long right = new Long(nums[i]);

            if(!big.isEmpty() && left <= big.peek())  big.remove(left);
            else small.remove(left);

            if(!big.isEmpty() && right <= big.peek())  big.add( new Long(right));
            else small.add( new Long(right));

            while (big.size() < k/2)    big.add(small.poll());
            while (big.size() > k/2)    small.add(big.poll());
            res[i-k+1] = get(k);
        }
        return res;
    }
}
