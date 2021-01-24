package feture.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class M0802 {
    /**
     * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。
     * 设计一种算法，寻找机器人从左上角移动到右下角的路径。
     *
     *网格中的障碍物和空位置分别用 1 和 0 来表示。
     *
     * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
     *
     * 示例 1:
     *
     * 输入:
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
     * 解释:
     * 输入中标粗的位置即为输出表示的路径，即
     * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
     * 说明：r 和 c 的值均不超过 100。
     *
     */
    private List<List<Integer>> res;
    int[][] men;
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return new ArrayList<>();
        res = new ArrayList<>();
        if (find(obstacleGrid, 0, 0)) {
            return res;
        }
        men = new int[obstacleGrid.length][obstacleGrid[0].length];
        return new ArrayList<>();
    }

    private boolean find(int[][] grid, int x, int y) {
        if (x >= grid.length || y >= grid[0].length || grid[x][y] == 1)
            return false;
        if (men[x][y] == 1)
            return false;
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            res.add(Arrays.asList(x,y));
            return true;
        }
        List<Integer> number = Arrays.asList(x, y);
        res.add(number);
        boolean a = find(grid, x + 1, y);
        if (a) {
            return true;
        }
        boolean b = find(grid, x, y + 1);
        if (b)
            return true;
        men[x][y] = 1;
        res.remove(res.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        M0802 m = new M0802();
        System.out.println(m.pathWithObstacles(new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}}));
    }
}
