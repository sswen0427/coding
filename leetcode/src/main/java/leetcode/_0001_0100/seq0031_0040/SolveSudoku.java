package leetcode._0001_0100.seq0031_0040;

import java.util.ArrayList;
import java.util.List;

public class SolveSudoku {

    class Solution1{
        private boolean[][] line = new boolean[9][9];
        private boolean[][] column = new boolean[9][9];
        private boolean[][][] block = new boolean[3][3][9];
        private boolean valid = false;
        private List<int[]> spaces = new ArrayList<>();

        private void dfs(char[][] board, int pos){
            if(pos == spaces.size()){
                valid = true;
                return;
            }
            int[] space = spaces.get(pos);
            int i = space[0], j = space[1];
            for(int digit = 0; digit < 9 && !valid; digit++){
                if(!line[i][digit] && !column[j][digit] && !block[i/3][j/3][digit]){
                    line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
                    board[i][j] = (char)(digit + '0' + 1);
                    dfs(board, pos+1);
                    line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = false;
                }
            }
        }

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++){
                    if(board[i][j] == '.'){
                        spaces.add(new int[]{i, j});
                    }else {
                        int digit = board[i][j] - '0' - 1;
                        line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
                    }
                }
            }
            dfs(board, 0);
        }
    }


    class Solution2{
        private int[] line = new int[9];
        private int[] column = new int[9];
        private int[][] block = new int[3][3];
        private boolean valid = false;
        private List<int[]> spaces = new ArrayList<>();


        private void flip(int i, int j, int digit){
            line[i] ^= (1 << digit);
            column[j] ^= (1 << digit);
            block[i/3][j/3] ^= (1 << digit);
        }

        private void dfs(char[][] board, int pos){
            if(pos == spaces.size()){
                valid = true;
                return;
            }
            int[] space = spaces.get(pos);
            int i = space[0], j = space[1];
            int mask = ~(line[i] | column[j] | block[i/3][j/3]) & 0x1ff;
            for(; mask != 0 && !valid; mask &= (mask - 1)){
                int digitMask = mask & (-mask);
                int digit = Integer.bitCount(digitMask-1);
                flip(i, j, digit);
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                flip(i, j, digit);
            }
        }

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++){
                    if(board[i][j] == '.'){
                        spaces.add(new int[]{i, j});
                    }else {
                        int digit = board[i][j] - '0' - 1;
                        flip(i, j, digit);
                    }
                }
            }
            dfs(board, 0);
        }
    }


    class Solution3{
        private int[] line = new int[9];
        private int[] column = new int[9];
        private int[][] block = new int[3][3];
        private boolean valid = false;
        private List<int[]> spaces = new ArrayList<>();


        private void flip(int i, int j, int digit){
            line[i] ^= (1 << digit);
            column[j] ^= (1 << digit);
            block[i/3][j/3] ^= (1 << digit);
        }

        private void dfs(char[][] board, int pos){
            if(pos == spaces.size()){
                valid = true;
                return;
            }
            int[] space = spaces.get(pos);
            int i = space[0], j = space[1];
            int mask = ~(line[i] | column[j] | block[i/3][j/3]) & 0x1ff;
            for(; mask != 0 && !valid; mask &= (mask - 1)){
                int digitMask = mask & (-mask);
                int digit = Integer.bitCount(digitMask-1);
                flip(i, j, digit);
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                flip(i, j, digit);
            }
        }

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++){
                    if(board[i][j] != '.'){
                        int digit = board[i][j] - '0' - 1;
                        flip(i, j, digit);
                    }
                }
            }
            while (true){
                boolean modified = false;
                for(int i = 0; i < 9; i++){
                    for(int j = 0; j < 9; j++){
                        if(board[i][j] == '.'){
                            int mask = ~(line[i] | column[j] | block[i/3][j/3]) & 0x1ff;
                            if((mask & (mask-1)) == 0){
                                int digit = Integer.bitCount(mask-1);
                                flip(i, j, digit);
                                board[i][j] = (char)(digit + '0' + 1);
                                modified = true;
                            }
                        }
                    }
                }
                if(!modified) break;
            }
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    if(board[i][j] == '.'){
                        spaces.add(new int[]{i, j});
                    }
                }
            }
            dfs(board, 0);
        }
    }
}
