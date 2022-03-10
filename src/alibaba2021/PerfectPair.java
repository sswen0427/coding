package alibaba2021;

import java.util.*;

public class PerfectPair {

    private static String getString(int[] nums){
        StringBuilder stringBuilder = new StringBuilder();
        for(int num : nums){
            if(num > 0) stringBuilder.append("+" + num);
            else if(num < 0) stringBuilder.append(num);
            else stringBuilder.append("0");
        }
        return stringBuilder.toString();
    }

    private static String reverseString(int[] nums){
        StringBuilder stringBuilder = new StringBuilder();
        for(int num : nums){
            if(num > 0) stringBuilder.append("-" + num);
            else if(num < 0) stringBuilder.append("+" + -num);
            else stringBuilder.append("0");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[][] nums = new int[n][k-1];
        int sum = 0;

        for(int i = 0; i < n; i++){
            int first = sc.nextInt();
            for(int j = 1; j < k; j++){
                nums[i][j-1] = first - sc.nextInt();
            }
            String sequentialString = getString(nums[i]);
            String reverseString = reverseString(nums[i]);
            if(map.containsKey(reverseString)){
                sum += map.get(reverseString);
            }
            map.put(sequentialString, map.getOrDefault(sequentialString, 0) + 1);
        }
        System.out.println(sum);
    }
}
