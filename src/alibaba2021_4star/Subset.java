package alibaba2021_4star;

import java.util.*;

public class Subset{
    private static int longestSubArray(int[] nums) {
        //tails[k] 的值代表长度为k+1子序列 的尾部元素值
        int[] tails = new int[nums.length];
        // res 为 tails当前长度
        int res = 0;
        for (int num : nums){
            int left = 0;
            //right为数组的长度，而不是length-1，这点要注意
            int right = res;
            while(left < right) {
                int m = left + (right - left)/2;
                if(tails[m] < num)  left = m + 1;
                else  right = m;
            }
            tails[left] = num;
            if(right == res)    res++;
        }
        return  res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            int n = sc.nextInt();
            int[][] t = new int[n][2];
            int[] nums = new int[n];
            for (int j = 0; j < n; j++)    t[j][0] = sc.nextInt();
            for (int j = 0; j < n; j++)    t[j][1] = sc.nextInt();
            //x相同的情况下y更大的排序在前面（不然的话会重复统计相同的x）
            Arrays.sort(t, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] < o2[0]) return -1;
                    else if(o1[0] > o2[0]) return 1;
                    else return -Integer.compare(o1[1], o2[1]);
                }
            });

            for (int j = 0; j < n; j++)     nums[j] = t[j][1];
            System.out.println(longestSubArray(nums));
        }
    }
}
