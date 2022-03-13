package alibaba2021_4star;

import java.util.Scanner;

public class NumberOfPrograms {
    private static int total, n, m;
    private static int[][] matrix = null;
    private static final int MOD = 10000;


    private static void dfs(int x, int y){
        if(x == n-1 && y == m-1){
            total++;
            total %= MOD;
            return;
        }

        int energy = matrix[x][y];
        for(int i = x; i <= x + energy && i < n; i++){
            for(int j = y; j <= y + energy && j < m; j++){
                int dis = i + j - x - y;
                if(0 < dis && dis <= energy){
                    dfs(i, j);
                }else if(dis > energy){
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            matrix = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            total = 0;
            dfs(0, 0);
            System.out.println(total);
        }
    }
}
