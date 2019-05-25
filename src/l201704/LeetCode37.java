
package l201704;

/**
 * @author lanshan
 */
public class LeetCode37 {

    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[10][10];
        boolean[][] col = new boolean[10][10];
        boolean[][] mul = new boolean[10][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    mul[i / 3 * 3 + j / 3 + 1][num] = true;
                }
            }
        }
        get(row, col, mul, board, 0, 0);
    }

    public boolean get(boolean[][] row, boolean[][] col, boolean[][] mul, char[][] board, int i, int j) {
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i == 9) {
                return true;
            }
        }
        for (int k = 1; k <= 9; k++) {
            int mulnum = i / 3 * 3 + j / 3 + 1;
            if (!row[i][k] && !col[j][k] && !mul[mulnum][k]) {
                row[i][k] = true;
                col[j][k] = true;
                mul[mulnum][k] = true;
                board[i][j] = (char) (k + '0');
                if (get(row, col, mul, board, i, j)) {
                    return true;
                }
                row[i][k] = false;
                col[j][k] = false;
                mul[mulnum][k] = false;
                board[i][j] = '.';
            }
        }
        return false;
    }



}
