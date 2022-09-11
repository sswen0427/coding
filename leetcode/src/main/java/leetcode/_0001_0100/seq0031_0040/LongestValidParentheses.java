package leetcode._0001_0100.seq0031_0040;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses {
    // dp
    public int longestValidParentheses1(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = (i >= 2 ? dp[i-2] : 0)+ 2;
                }else if(i - dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1] + ((i-dp[i-1]) >= 2 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    // stack
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(-1);

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.addLast(i);
            }else {
                stack.pollLast();
                if(stack.isEmpty()){
                    stack.addLast(i);
                }else {
                    maxans = Math.max(maxans, i - stack.peekLast());
                }
            }
        }
        return maxans;
    }

    public int longestValidParentheses3(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
