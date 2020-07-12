package feture.dp.mid;

/**
 * @author lanshan
 */
public class Offer47 {
    class Solution {
        public int maxValue(int[][] grid) {
            if (grid == null || grid.length == 0)
                return 0;
            int m = grid.length;
            int n = grid[0].length;
            int[][] find = new int[m+1][n+1];
            for (int i = find.length - 2; i >= 0; i--) {
                for (int j = find[i].length-2; j >= 0; j--) {
                    find[i][j] = Math.max(find[i+1][j], find[i][j+1]) + grid[i][j];
                }
            }
            return find[0][0];
        }
    }
}
