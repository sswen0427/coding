package interview;

import java.util.*;

public class _0812_SolveNQueens {

    class Solution1{
        private List<List<String>> solutions = new ArrayList<>();
        private int[] queens;
        private Set<Integer> columns = new HashSet<>();
        private Set<Integer> diagonals1 = new HashSet<>();
        private Set<Integer> diagonals2 = new HashSet<>();

        private void backtrack(int row){
            if(row == queens.length){
                List<String> board = new ArrayList<>();
                for (int i = 0; i < queens.length; i++) {
                    char[] chars = new char[queens.length];
                    Arrays.fill(chars, '.');
                    chars[queens[i]] = 'Q';
                    board.add(new String(chars));
                }
                solutions.add(board);
                return;
            }
            for(int i = 0; i < queens.length; i++){
                if(columns.contains(i)) continue;
                if(diagonals1.contains(row - i)) continue;
                if(diagonals2.contains(row + i)) continue;

                queens[row] = i;
                columns.add(i);
                diagonals1.add(row-i);
                diagonals2.add(row+i);

                backtrack(row+1);

                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(row-i);
                diagonals2.remove(row+i);
            }
        }

        public List<List<String>> solveNQueens(int n) {
            queens = new int[n];
            Arrays.fill(queens, -1);
            backtrack(0);
            return solutions;
        }
    }


    class Solution2{
        private List<List<String>> solutions = new ArrayList<>();
        private int[] queens;

        private void backtrack(int n, int row, int columns, int diggonals1, int diagonals2){
            if(row == n){
                List<String> board = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    char[] chars = new char[n];
                    Arrays.fill(chars, '.');
                    chars[queens[i]] = 'Q';
                    board.add(new String(chars));
                }
                solutions.add(board);
                return;
            }
            int availablePositions = ((1 << n) - 1) & (~(columns | diggonals1 | diagonals2));
            while (availablePositions != 0){
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                int column = Integer.bitCount(position - 1);
                queens[row] = column;
                backtrack(n, row+1, columns|position, (diggonals1 | position) << 1, (diagonals2 | position) >> 1);
                queens[row] = -1;
            }
        }

        public List<List<String>> solveNQueens(int n) {
            queens = new int[n];
            Arrays.fill(queens, -1);
            backtrack(n, 0, 0, 0, 0);
            return solutions;
        }
    }
}
