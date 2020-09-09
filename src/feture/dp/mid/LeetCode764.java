
package feture.dp.mid;

import feture.util.LeetCodeUtil;

/**
 * @author lanshan
 */
public class LeetCode764 {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int max = -1;
        if (mines.length == 0)
            max = 0;
        int[][] res = new int[N][N];
        for (int[] mine : mines) {
            res[mine[0]][mine[1]] = -1;
        }
        LeetCodeUtil.print(res);
        lab: for (int[] re : res) {
            for (int j = 0; j < res.length; j++) {
                if (re[j] == 0) {
                    max = 0;
                    break lab;
                }
            }
        }
        if (max == -1)
            return 0;
        int length = N / 2 + N % 2;
        int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 1; i < length; i++) {
            int x = i, y = i;
            res[x][y] = find(res, x, y);
            max = Math.max(max, res[x][y]);
            for (int j = 0; j < direction.length;) {
                if (check(x + direction[j][0], y + direction[j][1], i, N)) {
                    j++;
                    continue;
                }
                x += direction[j][0];
                y += direction[j][1];
                if (x == i && y == i)
                    break;

                res[x][y] = find(res, x, y);
                max = Math.max(max, res[x][y]);
            }
        }
        return max + 1;
    }

    private boolean check(int x, int y, int i, int N) {
        return x < i || x > N - 1 - i || y < i || y > N - 1 - i;
    }

    private int find(int[][] res, int x, int y) {
        if (res[x][y] == -1)
            return -1;
        int min = res[x - 1][y];
        min = Math.min(min, res[x][y + 1]);
        min = Math.min(min, res[x + 1][y]);
        min = Math.min(min, res[x][y - 1]);
        return min + 1;
    }

    /**
     * 3
     * [[0,1],[0,2],[1,0],[1,1],[1,2],[2,0],[2,1],[2,2]]
     *
     *
     * 5
     * [{0,1},{0,2},{0,3},{0,4},{1,0},{1,1},{1,2},{1,3},{1,4},{2,0},{2,1},{2,3},{2,4},{3,1},{3,2},{3,3},{3,4},{4,0},{4,1},{4,2},{4,3},{4,4}]
     */
    public static void main(String[] args) {
        LeetCode764 l = new LeetCode764();
        System.out.println(l.orderOfLargestPlusSign(5, new int[][] { {3,0},{3,3} }));
    }
}
