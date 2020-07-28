package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode64 {

    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 示例:
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     */
    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0)
                return 0;
            int[][] sum = new int[grid.length+1][grid[0].length+1];
            for (int i = 0; i < sum.length; i++) {
                sum[i][sum[0].length-1] = Integer.MAX_VALUE;
            }
            for (int j = 0; j < sum[0].length; j++) {
                sum[sum.length-1][j] = Integer.MAX_VALUE;
            }
            for (int i = grid.length - 1; i >= 0; i--) {
                for (int j = grid[i].length - 1; j >= 0; j--) {
                    if (i == grid.length - 1 && j == grid[i].length - 1) {
                        sum[i][j] = grid[i][j];
                        continue;
                    }
                    sum[i][j] = grid[i][j] + Math.min(sum[i+1][j], sum[i][j+1]);
                }
            }
            return sum[0][0];
        }
    }
}
