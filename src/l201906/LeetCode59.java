package l201906;

/**
 * @author lanshan
 */
public class LeetCode59 {
    /**
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     *
     * 示例:
     *
     * 输入: 3
     * 输出:
     * [
     *  [ 1, 2, 3 ],
     *  [ 8, 9, 4 ],
     *  [ 7, 6, 5 ]
     * ]
     *
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] mark = new int[n][n];
        int right = 1, down = 2, left = 3, up = 4;
        int directe = right;
        int x = 0, y = 0;
        int count = 1;
        while (count <= n*n) {
            matrix[x][y] = count++;
            mark[x][y] = 1;
            if (directe == right) {
                y++;
                if (y == n || mark[x][y] == 1) {
                    directe = down;
                    --y;
                    ++x;
                }
            } else if (directe == down) {
                x++;
                if (x == n || mark[x][y] == 1) {
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
        return matrix;
    }

    public static void main(String[] args) {
        LeetCode59 l = new LeetCode59();
        int[][] matrix = l.generateMatrix(3);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%3d", anInt);
            }
            System.out.println();
        }
    }
}
