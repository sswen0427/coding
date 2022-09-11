package alibaba2021_4star;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Subsegment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        while (right < n){
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (left <= right && map.get(num) >= m){
                sum += n - right;
                map.put(nums[left], map.get(nums[left])- 1);
                left++;
            }
            right++;
        }
        System.out.println(sum);
    }
}
