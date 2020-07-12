package feture.dp.easy;

/**
 * @author lanshan
 */
public class LeetCode121 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0)
                return 0;
            int max = 0;
            for (int i = 0; i < prices.length-1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    max = Math.max(max, prices[j]-prices[i]);
                }
            }
            return max;
        }
        
        public int maxProfit2(int[] prices) {
            if (prices == null || prices.length == 0)
                return 0;
            int max = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                max = Math.max(max, prices[i] - min);
            }
            return max;
        }
    }
}
