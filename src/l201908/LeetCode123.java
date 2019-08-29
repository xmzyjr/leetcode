
package l201908;

/**
 * @author lanshan
 */
public class LeetCode123 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n + 1][max_k + 1][2];
        for (int i = 0; i <= n; i++)
            dp[i][0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == 0) {
                    dp[0][k][0] = 0;
                    dp[0][k][1] = Integer.MIN_VALUE;

                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i-1]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i-1]);
            }
        }
        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n][max_k][0];
    }

    public static void main(String[] args) {
        LeetCode123 l = new LeetCode123();
        System.out.println(l.maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
    }
}
