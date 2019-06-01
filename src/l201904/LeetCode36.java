
package l201904;

/**
 * @author lanshan
 */
public class LeetCode36 {

    public boolean isValidSudoku(char[][] board) {
        int[][] num = new int[9][9];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                num[i][j] = i / 3 * 3 + j / 3 + 1;
            }
        }

        boolean[][] checkRow = new boolean[9][9];
        boolean[][] checkCol = new boolean[9][9];
        boolean[][] check3mul3 = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                boolean check = check3mul3fun(board, i, j, num, check3mul3, num[i][j], new boolean[10])
                        && checkrow(board, i, checkRow, new boolean[10])
                        && checkcol(board, j, checkCol, new boolean[10]);
                if (!check) {
                    return false;
                }
            }
        }
        return true;
    }

    // limit 比如当前是 5
    public boolean check3mul3fun(char[][] board, int row, int col, int[][] num, boolean[][] check, int limit,
                                 boolean[] hash) {
        if (row < 0 || row == board.length || col < 0 || col == board.length || num[row][col] != limit
                || check[row][col]) {
            return true;
        }
        if (board[row][col] != '.') {
            int num1 = board[row][col] - '0';
            if (hash[num1]) {
                return false;
            }
            hash[num1] = true;
        }

        check[row][col] = true;
        return check3mul3fun(board, row - 1, col, num, check, limit, hash)
                && check3mul3fun(board, row, col + 1, num, check, limit, hash)
                && check3mul3fun(board, row + 1, col, num, check, limit, hash)
                && check3mul3fun(board, row, col - 1, num, check, limit, hash);
    }

    public boolean checkrow(char[][] board, int row, boolean[][] check, boolean[] hash) {
        if (row == board.length) {
            return true;
        }
        if (check[row][0]) {
            return true;
        }
        for (int i = 0; i < check[row].length; i++) {
            if (board[row][i] == '.') {
                check[row][i] = true;
            } else {
                int num1 = board[row][i] - '0';
                if (hash[num1]) {
                    return false;
                }
                check[row][i] = true;
                hash[num1] = true;
            }
        }
        return true;
    }

    public boolean checkcol(char[][] board, int col, boolean[][] check, boolean[] hash) {
        if (col == board.length) {
            return true;
        }
        if (check[0][col]) {
            return true;
        }
        for (int i = 0; i < check[0].length; i++) {
            if (board[i][col] == '.') {
                check[i][col] = true;
            } else {
                int num1 = board[i][col] - '0';
                if (hash[num1]) {
                    return false;
                }
                check[i][col] = true;
                hash[num1] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] borde = {
                { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' },
                { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' },
                { '.', '.', '4', '.', '.', '.', '.', '.', '.' } };
        LeetCode36 l = new LeetCode36();
        System.out.println(l.isValidSudoku(borde));
    }
}
