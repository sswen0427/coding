package swordpointtooffer.seq31_40;

public class MaximalRectangle {
    public int maximalRectangle(String[] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int[][] heights = new int[matrix.length + 1][matrix[0].length()];
        for(int i = 1; i < heights.length; i++){
            for(int j = 0; j < matrix[i-1].length(); j++){
                if(matrix[i-1].charAt(j) == '1'){
                    heights[i][j] = heights[i-1][j] + 1;
                }
            }
        }
        int ans = -1;
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        for(int i = 1; i < heights.length; i++){
            ans = Math.max(largestRectangleArea.largestRectangleArea(heights[i]), ans);
        }
        return ans;
    }
}
