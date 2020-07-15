package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode1277 {
    class Solution {
        public int countSquares(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (i-1<0 || j-1<0) {
                        continue;
                    }
                    if (matrix[i][j] == 1)
                        matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    sum += matrix[i][j];
                }
            }
            return sum;
        }
    }
    
}
