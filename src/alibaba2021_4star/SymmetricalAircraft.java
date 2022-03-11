package alibaba2021_4star;

import java.util.*;

public class SymmetricalAircraft {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][][] dp;
    private static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        char[][] maze = new char[n][m];
        dp = new int[n][m][6];
        int sx = 0, sy = 0, ex = 0, ey = 0;
        sc.nextLine();
        for(int i = 0; i < n; i++){
            maze[i] = sc.nextLine().toCharArray();
            for(int j = 0; j < maze[i].length; j++){
                if(maze[i][j] == 'S'){sx = i; sy = j;}
                if(maze[i][j] == 'E'){ex = i; ey = j;}
            }
        }
        bfs(maze, sx, sy, ex, ey);
        for(int i = 0; i < 6; i++){
            if(dp[ex][ey][i] != 0){
                System.out.println(dp[ex][ey][i]);
                return;
            }
        }
        System.out.println(-1);
    }

    private static void bfs(char[][] maze, int sx, int sy, int ex, int ey){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerFirst(new int[]{sx, sy, 0});
        while (!queue.isEmpty()){
            int[] status = queue.pollLast();
            int x = status[0], y = status[1], t = status[2];
            int nx = 0, ny = 0, nt = 0;
            for(int i = 0; i < 5; i++){
                if(i == 4){
                    nx = n - 1 - x; ny = m - 1 - y; nt = t + 1;
                }else{
                    nx = x + dx[i]; ny = y + dy[i]; nt = t;
                }
                if(0 <= nx && nx < n && 0 <= ny && ny < m && nt < 6 &&
                        maze[nx][ny] != '#' && dp[nx][ny][nt] == 0){
                    dp[nx][ny][nt] = dp[x][y][t] + 1;
                    if(nx == ex && ny == ey) return;
                    queue.offerFirst(new int[]{nx, ny, nt});
                }
            }
        }
    }
}
