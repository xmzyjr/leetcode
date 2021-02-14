package feture.ms;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class M1723 {
    /**
     * 给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。
     *
     * 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。
     * 若有多个满足条件的子方阵，返回 r 最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。
     *
     * 示例 1:
     *
     * 输入:
     * [
     *    [1,0,1],
     *    [0,0,1],
     *    [0,0,1]
     * ]
     * 输出: [1,0,2]
     * 解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
     * 示例 2:
     *
     * 输入:
     * [
     *    [0,1,1],
     *    [1,0,1],
     *    [1,1,0]
     * ]
     * 输出: [0,0,1]
     * 提示：
     *
     * matrix.length == matrix[0].length <= 200
     *
     */
    static class Node {
        int x,y;
    }

    public int[] findSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        Node[][] first = new Node[matrix.length][matrix.length];
        Node[][] second = new Node[matrix.length][matrix.length];
        int r = 0, c = 0, size = 0;

        buildFirst(matrix, first);
        buildSecond(matrix, second);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1)
                    continue;
                int min = Math.min(first[i][j].x, first[i][j].y);
                if (min == 1) {
                    if (size == 0) {
                        r = i;
                        c = j;
                        size = 1;
                    }
                    continue;
                }
                int tt = 1;
                for (int t = min, x = i + 1, y = j + 1; t > 1 && x < matrix.length
                        && y < matrix.length; t--, x++, y++) {
                    ++tt;
                    int tempSize = Math.min(Math.min(min, second[x][y].x), second[x][y].y);
                    if (tt > tempSize)
                        continue;
                    if (tt > size) {
                        r = i;
                        c = j;
                        size = tt;
                        if (size == matrix.length - r)
                            return new int[] { r, c, size };
                    }
                }
            }
        }
        if (size == 0)
            return new int[0];
        return new int[] { r, c, size };
    }

    private void buildFirst(int[][] matrix, Node[][] first) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                first[i][j] = new Node();
                if (matrix[i][j] == 1)
                    continue;
                first[i][j].x = j + 1 == matrix[i].length ? 1 : first[i][j + 1].x + 1;
            }
        }
        for (int j = 0; j < matrix.length; j++) {
            for (int i = matrix.length - 1; i >= 0; i--) {
                if (matrix[i][j] == 1)
                    continue;
                first[i][j].y = i + 1 == matrix.length ? 1 : first[i + 1][j].y + 1;
            }
        }
    }

    private void buildSecond(int[][] matrix, Node[][] second) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                second[i][j] = new Node();
                if (matrix[i][j] == 1)
                    continue;
                second[i][j].x = j - 1 < 0 ? 1 : second[i][j - 1].x + 1;
            }
        }
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == 1)
                    continue;
                second[i][j].y = i - 1 < 0 ? 1 : second[i - 1][j].y + 1;
            }
        }
    }

    public static void main(String[] args) {
        M1723 m = new M1723();
        System.out.println(Arrays.toString(m.findSquare(new int[][] {
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 0, 0, 0, 1, 1, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 1, 1}
        })));
    }
}
