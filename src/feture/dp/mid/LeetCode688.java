
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode688 {

    public double knightProbability2(int N, int K, int r, int c) {
        return find(N, K, r, c);
    }

    public double knightProbability(int N, int K, int r, int c) {
        if (r < 0 || r > N - 1 || c < 0 || c > N - 1)
            return 0;
        if (K == 0)
            return 1;
        if (N <= 2)
            return 0;
        double[][][] num = new double[N][N][K + 1];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j][0] = 1;
            }
        }
        for (int z = 1; z < K + 1; z++) {
            for (int i = 0; i < num.length; i++) {
                for (int j = 0; j < num[i].length; j++) {
                    double i1 = get(num, N, z, i - 1, j - 2);
                    double i2 = get(num, N, z, i - 2, j - 1);
                    double i3 = get(num, N, z, i - 2, j + 1);
                    double i4 = get(num, N, z, i - 1, j + 2);
                    double i5 = get(num, N, z, i + 1, j - 2);
                    double i6 = get(num, N, z, i + 2, j - 1);
                    double i7 = get(num, N, z, i + 2, j + 1);
                    double i8 = get(num, N, z, i + 1, j + 2);
                    double res = 0.125 * (i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8);
                    num[i][j][z] = res;
                }
            }
        }
        return num[r][c][K];
    }

    private double get(double[][][] num, int n, int k, int x, int y) {
        if (x < 0 || x > n - 1 || y < 0 || y > n - 1)
            return 0;
        return num[x][y][k - 1];
    }

    private double find(int n, int k, int x, int y) {
        if (x < 0 || x > n - 1 || y < 0 || y > n - 1)
            return 0;
        if (k == 0)
            return 1;
        return 0.125 * (find(n, k - 1, x - 1, y - 2) + find(n, k - 1, x - 2, y - 1) + find(n, k - 1, x - 2, y + 1)
                + find(n, k - 1, x - 1, y + 2) + find(n, k - 1, x + 1, y - 2) + find(n, k - 1, x + 2, y - 1)
                + find(n, k - 1, x + 2, y + 1) + find(n, k - 1, x + 1, y + 2));
    }

    public static void main(String[] args) {
        LeetCode688 l = new LeetCode688();
        System.out.println(l.knightProbability(3, 2, 0, 0));
    }
}
