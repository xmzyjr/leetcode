
package feture.greedy.easy;

/**
 * @author lanshan
 */
public class LeetCode122 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        return find(prices, 0, false);
    }
    
    private int find(int[] prices, int index, boolean buy) {
        if (index == prices.length)
            return 0;
        if (buy) {
            return Math.max(find(prices, index + 1, false) + prices[index], find(prices, index + 1, true));
        }
        return Math.max(find(prices, index + 1, false), find(prices, index + 1, true) - prices[index]);
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int[][] res = new int[prices.length + 1][2];
        for (int i = res.length - 2; i >= 0; i--) {
            res[i][1] = Math.max(res[i + 1][0] + prices[i], res[i + 1][1]);
            res[i][0] = Math.max(res[i + 1][0], res[i + 1][1] - prices[i]);
        }
        return res[0][0];
    }

    public static void main(String[] args) {
        LeetCode122 l = new LeetCode122();
        System.out.println(l.maxProfit2(new int[] {7, 1, 5, 3, 6, 4}));
    }
}
