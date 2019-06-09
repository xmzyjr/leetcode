
package l201906;

/**
 * @author lanshan
 */
public class LeetCode64 {

    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 说明：每次只能向下或者向右移动一步。
     * 示例:
     * 输入:
     * [
     *   [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     */
    public int minPathSum(int[][] grid) {
        //        return get(grid,grid.length,grid[0].length,0,0);
        int m = grid.length;
        int n = grid[0].length;
        int[] num = new int[n + 1];
        num[n - 1] = grid[m - 1][n - 1];
        for (int i = m - 1; i >= 0; i--) {
            int start = i == m - 1 ? n - 2 : n - 1;
            for (int j = start; j >= 0; j--) {
                if (j + 1 == n) {
                    num[j] += grid[i][j];
                } else if (i == m - 1) {
                    num[j] = num[j + 1] + grid[i][j];
                } else {
                    num[j] = Math.min(num[j + 1], num[j]) + grid[i][j];
                }

            }
        }
        return num[0];
    }

    public int get(int[][] grid, int m, int n, int x, int y) {
        if (x == m || y == n) {
            return -1;
        }
        if (x == m - 1 && y == n - 1) {
            return grid[x][y];
        }
        int down = get(grid, m, n, x + 1, y);
        int right = get(grid, m, n, x, y + 1);
        if (down != -1 && right != -1) {
            return Math.min(down, right) + grid[x][y];
        } else if (down != -1) {
            return down + grid[x][y];
        } else if (right != -1) {
            return right + grid[x][y];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        LeetCode64 l = new LeetCode64();
        System.out.println(l.minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
    }

}
