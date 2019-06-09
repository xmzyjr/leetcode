
package l201906;

/**
 * @author lanshan
 */
public class LeetCode63 {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * 说明：m 和 n 的值均不超过 100。
     * 示例 1:
     * 输入:
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * 输出: 2
     * 解释:
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null || obstacleGrid.length==0 ||
                (obstacleGrid.length==1 && obstacleGrid[0][0]==1)) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int[] num = new int[n + 1];
        num[n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            int start = i == m - 1 ? n - 2 : n - 1;
            for (int j = start; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    num[j] = num[j + 1] + num[j];
                } else {
                    num[j] = 0;
                }

            }
        }
        return num[0];
    }

    public int get(int[][] obstacleGrid, int m, int n, int x, int y) {
        if (x == m || y == n || obstacleGrid[x][y] == 1) {
            return 0;
        }
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        return get(obstacleGrid, m, n, x + 1, y) + get(obstacleGrid, m, n, x, y + 1);
    }

}
