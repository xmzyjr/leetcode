
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode1314 {

    class Solution {

        public int[][] matrixBlockSum(int[][] mat, int K) {
            if (mat == null || mat.length == 0) {
                return new int[0][0];
            }
            int[][] temp = new int[mat.length][mat[0].length];

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    int left = j - 1 >= 0 ? temp[i][j - 1] : 0;
                    int top = i - 1 >= 0 ? temp[i - 1][j] : 0;
                    int leftTop = j - 1 >= 0 && i - 1 >= 0 ? temp[i - 1][j - 1] : 0;
                    temp[i][j] = left + top - leftTop + mat[i][j];
                }
            }
            // i,j = (i-k, j-k), (i+k,j+k) ===> temp[i+k][j+k] - temp[i+k][j-k-1] - temp[i-k-1][j+k] + temp[i-k-1][j-k-1]
            int[][] answer = new int[mat.length][mat[0].length];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    int down = i + K < mat.length ? i + K : mat.length - 1;
                    int right = j + K < mat[i].length ? j + K : mat[i].length - 1;
                    int left = j - K - 1 >= 0 ? temp[down][j - K - 1] : 0;
                    int top = i - K - 1 >= 0 ? temp[i - K - 1][right] : 0;
                    int leftTop = i - K - 1 >= 0 && j - K - 1 >= 0 ? temp[i - K - 1][j - K - 1] : 0;
                    answer[i][j] = temp[down][right] - left - top + leftTop;
                }
            }
            return answer;
        }
    }
}
