package alibaba2021_4star;

import java.util.Scanner;

public class NumberOfPrograms {
    private static int n, m;
    private static int[][] matrix = null;
    private static final int MOD = 10000;


    private static int cal(){
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int energy = matrix[i][j];

                for(int dx = 0; dx <= energy; dx++){
                    for(int dy = 0; dy <= energy-dx; dy++){
                        if(dx == 0 && dy == 0)  continue;
                        int nx = i+dx, ny = j+dy;
                        if(nx < n && ny < m){
                            dp[nx][ny] = (dp[i][j] + dp[nx][ny]) % MOD;
                        }
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0){
            n = sc.nextInt();
            m = sc.nextInt();
            matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            System.out.println(cal());
        }
    }
}
