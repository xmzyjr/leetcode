
package l201905;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode54 {

    /**
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * 示例 1:
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * 示例 2:
     * 输入:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int count = m * n;
        int[][] mark = new int[m][n];
        int right = 1, down = 2, left = 3, up = 4;
        int directe = right;
        int x = 0, y = 0;
        while (count > 0) {
            list.add(matrix[x][y]);
            mark[x][y] = 1;
            count--;
            if (directe == right) {
                y++;
                if (y == n || mark[x][y] == 1) {
                    directe = down;
                    --y;
                    ++x;
                }
            } else if (directe == down) {
                x++;
                if (x == m || mark[x][y] == 1) {
                    directe = left;
                    --x;
                    --y;
                }

            } else if (directe == left) {
                --y;
                if (y < 0 || mark[x][y] == 1) {
                    directe = up;
                    ++y;
                    --x;
                }
            } else {
                --x;
                if (x < 0 || mark[x][y] == 1) {
                    directe = right;
                    ++x;
                    ++y;
                }
            }
        }
        return list;
    }
}
