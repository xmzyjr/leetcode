
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode1314 {

    /**
     * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 
     *
     * i - K <= r <= i + K, j - K <= c <= j + K 
     * (r, c) 在矩阵内。
     *  
     *
     * 示例 1：
     *
     * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
     * 输出：[[12,21,16],[27,45,33],[24,39,28]]
     * 示例 2：
     *
     * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
     * 输出：[[45,45,45],[45,45,45],[45,45,45]]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/matrix-block-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
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
