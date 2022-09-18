package leetcode._0201_0300.seq0221_0230;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length, column = matrix[0].length;
        int maxSide = 0;

        int[][] dp = new int[row+1][column+1];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(matrix[i][j] == '1'){
                    dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j], dp[i][j+1]), dp[i][j]) + 1;
                    maxSide = Math.max(maxSide, dp[i+1][j+1]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
