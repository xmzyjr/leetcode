package feture.dp.mid;

import java.util.Map;

/**
 * @author lanshan
 */
public class LeetCode714 {
    static class Solution {

        private Map<Integer, Integer> buyMap;
        private Map<Integer, Integer> notBuyMap;
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length <= 1)
                return 0;
            int s_i_0 = 0, s_i_1 = Integer.MIN_VALUE + Math.max(prices[0], fee);
            for (int i = 0; i < prices.length; i++) {
                int temp = s_i_0;
                s_i_0 = Math.max(s_i_0, s_i_1 + prices[i] - fee);
                s_i_1 = Math.max(s_i_1, temp - prices[i]);
            }
            return s_i_0;
        }

        private int find(int[] prices, int fee, int index, boolean buy, int money) {
            if (index == prices.length - 1) {
                if (buy) {
                    money = Math.max(money + prices[index] - fee, money);
                }
                return money;
            }
            if (!buy) {
                int buyIt = find(prices, fee, index + 1, true, money - prices[index]);
                int notBuyIt = find(prices, fee, index + 1, false, money);
                return Math.max(buyIt, notBuyIt);
            }
            int notBuyIt = find(prices, fee, index + 1, true, money);
            int sale = find(prices, fee, index + 1, false, money + prices[index] - fee);
            return Math.max(notBuyIt, sale);
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.maxProfit(new int[] {1, 3, 2, 8, 4, 9}, 2));
        }
    }
}
