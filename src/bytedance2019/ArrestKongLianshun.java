package bytedance2019;

import java.util.Scanner;

public class ArrestKongLianshun {
    private static final int MOD = 99997867;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] buildings = new int[n];
        for(int i = 0; i < n; i++){
            buildings[i] = sc.nextInt();
        }
        long sum = 0;
        int left = 0, right = 0;
        while (left < n-2){
            while (right < n && buildings[right] - buildings[left] <= d){
                right++;
            }
            if(right - left - 2 > 0){
                // 一定要多写下面这一行， long型的变量才可以，否则会越界
                long num = right - left - 1;
                sum = (sum + (num * (num - 1) / 2)) % MOD;
                // 越界了
                //sum = (sum + ((right - left - 1) * (right - left - 2) / 2)) % MOD;
            }
            left++;
        }
        System.out.println(sum);
    }
}
