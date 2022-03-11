package alibaba2021_4star;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Subset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int[][] nums = new int[n][2];
            for(int j = 0; j < n; j++){
                nums[j][0] = sc.nextInt();
            }
            for(int j = 0; j < n; j++){
                nums[j][1] = sc.nextInt();
            }
            Arrays.sort(nums, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] < o2[0])  return -1;
                    else if(o1[0] > o2[0])  return 1;
                    else if(o1[1] < o2[1])  return -1;
                    else if(o1[1] > o2[1])  return 1;
                    else return 0;
                }
            });
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int max = 1;
            for(int j = 1; j < dp.length; j++){
                for(int k = 0; k < j; k++){
                    if(nums[k][1] < nums[j][1] && nums[k][0] < nums[j][0] && dp[k] >= dp[j]){
                        dp[j] = dp[k] + 1;
                    }
                }
                if(dp[j] > max) max = dp[j];
            }
            System.out.println(max);
        }
    }
}
