
package l201906;

/**
 * @author lanshan
 */
public class LeetCode74 {

    /**
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 示例 1:
     * 输入:
     * matrix = [
     * [1, 3, 5, 7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 3
     * 输出: true
     * 示例 2:
     * 输入:
     * matrix = [
     * [1, 3, 5, 7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 13
     * 输出: false
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int x = matrix.length;
        int y = matrix[0].length;
        int x1 = 0, y1 = y - 1;
        while (x1 < x && y1 >= 0 && matrix[x1][y1] != target) {
            if (matrix[x1][y1] < target) {
                x1++;
            } else if (matrix[x1][y1] > target) {
                y1--;
            }
        }
        if (x1 == x || y1 < 0 || matrix[x1][y1] != target) {
            return false;
        }
        return matrix[x1][y1] == target;
    }
}
