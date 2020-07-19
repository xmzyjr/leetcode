package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode64 {
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
