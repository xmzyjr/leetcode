package feture.offer;

/**
 * @author lanshan
 */
public class Offer12 {
    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
     *
     * [["a","b","c","e"],
     * ["s","f","c","s"],
     * ["a","d","e","e"]]
     *
     * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     *
     * 输入：board = [["a","b"],["c","d"]], word = "abcd"
     * 输出：false
     *  
     *
     * 提示：
     *
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     */
    int[][] temp;
    boolean res;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        char[] words = word.toCharArray();
        temp = new int[board.length][board[0].length];
        res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (res)
                    return true;
                find(board, words, i, j, 0);
            }
        }
        return res;
    }

    private void find(char[][] board, char[] words, int x, int y, int index) {
        if (res || x < 0 || y < 0 || x >= board.length || y >= board[0].length || temp[x][y] == 1)
            return;
        if (board[x][y] != words[index])
            return;
        if (index == words.length - 1) {
            res = true;
            return;
        }
        temp[x][y] = 1;
        find(board, words, x, y + 1, index + 1);
        find(board, words, x + 1, y, index + 1);
        find(board, words, x, y - 1, index + 1);
        find(board, words, x - 1, y, index + 1);
        temp[x][y] = 0;
    }
    
    
}
