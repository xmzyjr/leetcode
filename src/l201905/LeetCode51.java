
package l201905;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode51 {

    /**
     * 上图为 8 皇后问题的一种解法。
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * 示例:
     * 输入: 4
     * 输出: [
     * [".Q..", // 解法 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * ["..Q.", // 解法 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     * 解释: 4 皇后问题存在两个不同的解法。
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[][] nums = new int[n][n];
        doSolve(nums, 0, res);
        return res;
    }

    public void doSolve(int[][] nums, int index, List<List<String>> res) {
        if (index == nums.length) {
            res.add(getQueens(nums));
            return;
        }
        for (int i = 0; i < nums[index].length; i++) {
            if (check(nums, index, i)) {
                nums[index][i] = 1;
                doSolve(nums, index + 1, res);
                nums[index][i] = 0;
            }
        }
    }

    public boolean check(int[][] nums, int i, int j) {
        int len = nums[i].length;
        // check x
        for (int k = 0; k < len; k++) {
            if (nums[i][k] == 1) {
                return false;
            }
        }
        // check y
        for (int k = 0; k < len; k++) {
            if (nums[k][j] == 1) {
                return false;
            }
        }
        // check -x -y
        for (int x = i, y = j; x >= 0 && y >= 0; --x, --y) {
            if (nums[x][y] == 1) {
                return false;
            }
        }
        // check +x +y
        for (int x = i, y = j; x < len && y < len; ++x, ++y) {
            if (nums[x][y] == 1) {
                return false;
            }
        }
        // check +x -y
        for (int x = i, y = j; x < len && y >= 0; ++x, --y) {
            if (nums[x][y] == 1) {
                return false;
            }
        }
        // check -x +y
        for (int x = i, y = j; x >= 0 && y < len; --x, ++y) {
            if (nums[x][y] == 1) {
                return false;
            }
        }
        return true;
    }

    public List<String> getQueens(int[][] nums) {
        List<String> res = new ArrayList<>();
        for (int[] num : nums) {
            StringBuilder sb = new StringBuilder();
            for (int i : num) {
                if (i == 0) {
                    sb.append(".");
                } else {
                    sb.append("Q");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode51 l = new LeetCode51();
        System.out.println(l.solveNQueens(4));
    }

}
