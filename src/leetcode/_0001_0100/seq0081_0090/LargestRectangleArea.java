package leetcode._0001_0100.seq0081_0090;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < n; i++){
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]){
                stack.pollLast();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peekLast());
            stack.addLast(i);
        }

        stack.clear();
        for(int i = n-1; i >= 0; i--){
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]){
                stack.pollLast();
            }
            right[i] = (stack.isEmpty() ? n : stack.peekLast());
            stack.addLast(i);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
