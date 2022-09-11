package alibaba2021;

import java.util.Scanner;

public class MagicMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] nums = new long[n][3];

        long[] res = new long[3];
        long[] tmp = new long[3];
        for(int col = 0; col < 3; col++){
            for(int row = 0; row < n; row++){
                nums[row][col] = sc.nextLong();
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                tmp[j] = Math.min(Math.abs(nums[i][j] - nums[i-1][0]) + res[0],
                        Math.min(Math.abs(nums[i][j] - nums[i-1][1]) + res[1],
                                Math.abs(nums[i][j] - nums[i-1][2]) + res[2]));
            }
            for(int j = 0; j < 3; j++){
                res[j] = tmp[j];
            }
        }
        System.out.println(Math.min(res[0], Math.min(res[1], res[2])));
    }
}