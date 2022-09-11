package alibaba2021;

import java.util.Arrays;
import java.util.Scanner;

public class InternationalConference {
    public static void main(String[] args) {
        // 要想相邻元素的绝对差之和最大，就要保证所有数对的绝对差尽可能均匀分布。
        // 先将数组进行排序，然后将其分为前后两个子数组，按顺序取出两个子数组的元素组成数对。
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        int mid = (n % 2 == 0) ? n/2 : n/2+1;
        int[] res = new int[n];
        for(int i = 0; i < mid; i++){
            res[i * 2] = nums[i];
        }
        for(int i = mid; i < nums.length; i++){
            res[(i-mid)*2+1] = nums[i];
        }
        System.out.println();
        long sum = 0;
        for(int i = 0; i < res.length; i++){
            sum += Math.abs(res[i] - res[i+1 == res.length ? 0 : i+1]);
        }
        System.out.println(sum);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}
