package alibaba2021_4star;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Candy {
    private static int cal(int[][] weightValue, int size, int m){
        // dp[i][j]表示将前i件物品装进限重为j的背包可以获得的最大价值, 0<=i<=N, 0<=j<=W
        // dp[i][j] = max(dp[i−1][j], dp[i−1][j−w[i]]+v[i]) // j >= w[i]
        int[][] dp = new int[size+1][m+1];
        for(int i = 0; i < size; i++){
            for(int j = 1; j < dp[i].length; j++){
                if(j >= weightValue[i][0])
                    dp[i+1][j] = Math.max(dp[i][j], dp[i][j-weightValue[i][0]] + weightValue[i][1]);
            }
        }
        return dp[size][m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] weightValue = new int[n+1][2];
        for(int i = 1; i <= n; i++){
            weightValue[i][0] = sc.nextInt();
            weightValue[i][1] = 1;
        }
        int k = sc.nextInt();
        for(int i = 1; i <= k; i++){
            int first = sc.nextInt();
            int second = sc.nextInt();
            weightValue[first][0] += weightValue[second][0];
            weightValue[first][1] += weightValue[second][1];
            weightValue[second][0] = 0;
            weightValue[second][1] = 0;
        }
        Arrays.sort(weightValue, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -Integer.compare(o1[0], o2[0]);
            }
        });
        int size = 0;
        for(int i = 0; i < weightValue.length; i++){
            if(weightValue[i][0] > 0) size++;
            else break;
        }
        System.out.println(cal(weightValue, size, m));
    }
}
