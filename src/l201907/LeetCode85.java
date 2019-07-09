
package l201907;

import java.util.Stack;

/**
 * @author lanshan
 */
public class LeetCode85 {

    /**
     * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     * 示例:
     * 输入:
     * [
     * ["1","0","1","0","0"],
     * ["1","0","1","1","1"],
     * ["1","1","1","1","1"],
     * ["1","0","0","1","0"]
     * ]
     * 输出: 6
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int xLen = matrix.length;
        int yLen = matrix[0].length;

        int[][] num = new int[xLen][yLen];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                num[i][j] = matrix[i][j] - '0';
            }
        }

        int max = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                if (i != 0 && num[i][j] != 0) {
                    num[i][j] += num[i - 1][j];
                }
            }
            max = Math.max(max, large(num[i]));
        }
        return max;
    }

    public int large(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxarea;
    }
}
