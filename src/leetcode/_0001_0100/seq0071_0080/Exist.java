package leetcode._0001_0100.seq0071_0080;

public class Exist {
    private char[][] board;

    private String word;

    private int rows;

    private int cols;

    private boolean[][] isVisited;


    private boolean dfs(int row, int col, int index){
        if(row < 0 || row >= rows || col < 0 || col >= cols) return false;
        if(isVisited[row][col]) return false;
        if(board[row][col] != word.charAt(index)) return false;
        if(index == word.length()-1) return true;

        isVisited[row][col] = true;
        if(
            dfs(row-1, col, index+1) ||
            dfs(row+1, col, index+1) ||
            dfs(row, col-1, index+1)  ||
            dfs(row, col+1, index+1)){
            return true;
        }
        isVisited[row][col] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.rows = board.length;
        this.cols = board[0].length;
        this.isVisited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(dfs(i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
}
