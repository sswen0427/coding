package alibaba2021;
import java.util.*;
 
public class CrossRiver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int[] weights = new int[n+1]; // 每个人人的体重，从1开始记录体重，方便后续取值

            for(int j = 1; j <= n; j++) {
                weights[j] = sc.nextInt();
            }

            Arrays.sort(weights);

            int sum = 0;
			/*人数大于4时，过河时先将最重的两个人渡过去，此时有两种思路，
			  一种是最轻的人走2次，每次带一个。另一种是最轻和次轻先过去，
			  最轻回来，最重和次重坐过去，次轻回来。
			*/
            while(n >= 4) {
                // 两种方案的耗时
                // 1 最轻的带最重的两个人往返
                // 2 最轻和次轻过，最轻回，最重与次重过，次轻回
                // 每次重新出发相当于两个人已经到了河对岸，人数-2
                int planOneTime = weights[1] * 2 + weights[n] + weights[n-1];
                int planTwoTime = weights[1] + weights[2] * 2 + weights[n];
                sum += Math.min(planOneTime,planTwoTime);
                n -= 2;
            }
            // 对剩余人数特判
            if(n == 3)  sum += weights[1] + weights[2] + weights[3];
            if(n == 2)  sum += weights[2];
            if(n == 1)  sum += weights[1];
            System.out.println(sum);
        }
    }
}
/*
2
4
2 10 12 11
4
2 3 7 8
*/