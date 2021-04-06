package feture.offer;

/**
 * @author lanshan
 */
public class Offer13 {
    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
     * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
     * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
     * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     *
     *
     * 示例 1：
     *
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     * 示例 2：
     *
     * 输入：m = 3, n = 1, k = 0
     * 输出：1
     * 提示：
     *
     * 1 <= n,m <= 100
     * 0 <= k <= 20
     */
    int[][] num;
    public int movingCount(int m, int n, int k) {
        num = new int[m][n];
        return find(0, 0, k);
    }

    private int find(int x, int y, int k) {
        if (x < 0 || y < 0)
            return 0;
        if (x >= num.length || y >= num[0].length)
            return 0;
        if (num[x][y] == 1)
            return 0;
        num[x][y] = 1;
        if (check(x, y, k)) {
            return find(x, y + 1, k) + find(x + 1, y, k) + find(x, y - 1, k) + find(x - 1, y, k) + 1;
        }
        return 0;
    }

    private boolean check(int x, int y, int k) {
        int t = 0;
        while (x != 0) {
            t += (x % 10);
            x /= 10;
        }
        while (y != 0) {
            t += (y % 10);
            y /= 10;
        }
        return t <= k;
    }

    public static void main(String[] args) {
        Offer13 o = new Offer13();
        System.out.println(o.movingCount(2, 3, 1));
        System.out.println(o.movingCount(3, 1, 0));
        System.out.println(o.movingCount(100, 100, 20));
    }
}
