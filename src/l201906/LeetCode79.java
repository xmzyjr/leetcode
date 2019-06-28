
package l201906;

/**
 * @author lanshan
 */
public class LeetCode79 {

    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * 示例:
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * 给定 word = "ABCCED", 返回 true.
     * 给定 word = "SEE", 返回 true.
     * 给定 word = "ABCB", 返回 false.
     * [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
     * "ABCCED"
     * [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
     * "ABCESEEEFS"
     */

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int xLen = board.length;
        int yLen = board[0].length;
        boolean result = false;
        label: for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = get(board, new boolean[xLen][yLen], word.toCharArray(), 0, i, j);
                    if (result) {
                        break label;
                    }
                }
            }
        }
        return result;
    }

    public boolean get(char[][] board, boolean[][] check,
                       char[] word, int index, int x, int y) {
        if (index == word.length) {
            return true;
        }

        if (board[x][y] == word[index]) {
            check[x][y] = true;
            if (index + 1 == word.length) {
                return true;
            }
        }
        if (check(x + 1, y, board.length, board[0].length, check) && board[x + 1][y] == word[index + 1]) {
            index++;
            boolean b = get(board, check, word, index, x + 1, y);
            if (b) {
                return true;
            }
            check[x + 1][y] = false;
            index--;
        }
        if (check(x, y - 1, board.length, board[0].length, check) && board[x][y - 1] == word[index + 1]) {
            index++;
            boolean b = get(board, check, word, index, x, y - 1);
            if (b) {
                return true;
            }
            check[x][y - 1] = false;
            index--;
        }
        if (check(x, y + 1, board.length, board[0].length, check) && board[x][y + 1] == word[index + 1]) {
            index++;
            boolean b = get(board, check, word, index, x, y + 1);
            if (b) {
                return true;
            }
            check[x][y + 1] = false;
            index--;
        }
        if (check(x - 1, y, board.length, board[0].length, check) && board[x - 1][y] == word[index + 1]) {
            index++;
            boolean b = get(board, check, word, index, x - 1, y);
            if (b) {
                return true;
            }
            check[x - 1][y] = false;
            index--;
        }
        return false;
    }

    public boolean check(int x, int y, int xLen, int yLen, boolean[][] check) {
        return !(x < 0 || x >= xLen || y < 0 || y >= yLen || check[x][y]);
    }

    public static void main(String[] args) {
        LeetCode79 l = new LeetCode79();
        System.out.println(l.exist(
                new char[][] {
                        { 'A', 'B', 'C', 'E' },
                        { 'S', 'F', 'E', 'S' },
                        { 'A', 'D', 'E', 'E' } }, "ABCESEEEFS"));

    }

}
