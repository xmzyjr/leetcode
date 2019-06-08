
package l201906;

/**
 * @author lanshan
 */
public class LeetCode62 {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 问总共有多少条不同的路径？
     */
    public int uniquePaths(int m, int n) {
        int[] num = new int[n + 1];
        num[n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            int start = i == m - 1 ? n - 2 : n - 1;
            for (int j = start; j >= 0; j--) {
                num[j] = num[j + 1] + num[j];
            }
        }
        return num[0];
    }

    /**
     * 递归
     */
    public int get(int m, int n, int x, int y) {
        if (x == m || y == n) {
            return 0;
        }
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        return get(m, n, x + 1, y) + get(m, n, x, y + 1);
    }

    public static void main(String[] args) {
        LeetCode62 l = new LeetCode62();
        System.out.println(l.uniquePaths(3, 2));
    }
}
