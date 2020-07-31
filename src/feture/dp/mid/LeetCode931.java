
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode931 {

    /**
     * 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
     *
     * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
     *
     *  
     *
     * 示例：
     *
     * 输入：[[1,2,3],[4,5,6],[7,8,9]]
     * 输出：12
     * 解释：
     * 可能的下降路径有：
     * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
     * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
     * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
     * 和最小的下降路径是 [1,4,7]，所以答案是 12。
     *
     *  
     *
     * 提示：
     *
     * 1 <= A.length == A[0].length <= 100
     * -100 <= A[i][j] <= 100
     * 通过次数6,713提交次数10,983
     */
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0)
            return 0;
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = 0; j < A[i].length; j++) {
                int temp1 = j == 0 ? Integer.MAX_VALUE : A[i + 1][j - 1];
                int temp2 = A[i + 1][j];
                int temp3 = j == A[i].length - 1 ? Integer.MAX_VALUE : A[i + 1][j + 1];
                A[i][j] += Math.min(Math.min(temp1, temp2), temp3);
            }
        }
        int min = A[0][0];
        for (int i = 0; i < A.length; i++) {
            min = Math.min(A[0][i], min);
        }
        return min;
    }

}
