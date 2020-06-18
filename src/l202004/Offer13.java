package l202004;

/**
 * @author lanshan
 */
public class Offer13 {

    public int movingCount(int m, int n, int k) {
        if (k == 0)
            return 0;
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
        }
        int ans = 0;
        int i = 0;
        out: for (int j = 0; j < m; j++) {
            for (; i < n; i++) {
                if (i == 0) {
                    ans++;
                    continue;
                }
                if (check(i, j, k)) {
                    ans += Math.min(i + 1, m - j);
                } else {
                    break out;
                }
            }
            i = n - 1;
        }
        return ans;
    }

    public boolean check(int x, int y, int k) {
        int ans = 0;
        do {
            ans += (x % 10);
            x /= 10;
        } while (x > 0);

        do {
            ans += (y % 10);
            y /= 10;
        } while (y > 0);

        return ans <= k;
    }

    public static void main(String[] args) {
        Offer13 offer13 = new Offer13();
        System.out.println(offer13.movingCount(38, 15, 9));
    }
}
