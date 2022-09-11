package leetcode._0001_0100.seq0081_0090;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] nums = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    if(i == 0) nums[i][j] = 1;
                    else nums[i][j] = nums[i-1][j] + 1;
                }
            }
        }

        int max = 0;
        for(int i = 0; i < rows; i++){
            max = Math.max(max, LargestRectangleArea.largestRectangleArea(nums[i]));
        }
        return max;
    }
}
