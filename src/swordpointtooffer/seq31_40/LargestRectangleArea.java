package swordpointtooffer.seq31_40;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> mono_stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]){
                mono_stack.pop();
            }
            left[i] = mono_stack.isEmpty() ? -1 : mono_stack.peek();
            mono_stack.push(i);
        }

        mono_stack.clear();
        for(int i = n -1; i >= 0; i--){
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]){
                mono_stack.pop();
            }
            right[i] = mono_stack.isEmpty() ? n : mono_stack.peek();
            mono_stack.push(i);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
