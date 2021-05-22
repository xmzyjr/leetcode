package feture.bd;

/**
 * @author lanshan
 */
public class LeetCode221 {
    /**
     * 输入：matrix = [
     * ["1","0","1","0","0"],
     * ["1","0","1","1","1"],
     * ["1","1","1","1","1"],
     * ["1","0","0","1","0"]
     * ]
     * 输出：4
     *
     * [
     * ["1","1","1","1","0"],
     * ["1","2","2","2","0"],
     * ["1","2","3","3","1"],
     * ["1","2","3","4","1"],
     * ["0","0","1","1","1"]]
     * 提示：
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 300
     * matrix[i][j] 为 '0' 或 '1'
     */
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i != 0 && j != 0 && matrix[i][j] == '1') {
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1] - '0',
                            Math.min(matrix[i - 1][j] - '0', matrix[i][j - 1] - '0'));
                }
                max = Math.max(max, matrix[i][j] - '0');
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        LeetCode221 l = new LeetCode221();
    }
}
