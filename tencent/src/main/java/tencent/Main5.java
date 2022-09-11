package tencent;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < nums.length; i++){
            nums[i] = sc.nextInt();
        }
        if(n == 1){
            System.out.println(m);
            return;
        }
        if (n == 2){
            if(nums[1] > nums[0]){
                System.out.println(m + nums[1] - nums[0]);
            }else {
                System.out.println(m);
            }
        }
        System.out.println(m);
    }
}
