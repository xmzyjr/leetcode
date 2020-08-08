
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode309 {


    /**
     *
     给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

     设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

     你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     示例:

     输入: [1,2,3,0,2]
     输出: 3
     解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     */
    Integer[][] num;
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        num = new Integer[prices.length + 3][prices.length + 2];
        return find(prices, 0, -1);
    }

    /**
     * 1 3 2 5
     */
    private int find(int[] prices, int buy, int sale) {
        if (buy >= prices.length || sale >= prices.length || buy == sale)
            return 0;
        if (num[buy + 1][sale + 1] != null) {
            return num[buy + 1][sale + 1];
        }
        if (buy > sale) {
            num[buy + 1][sale + 1] = Math.max(find(prices, buy, buy + 1) - prices[buy], find(prices, buy + 1, sale));
            return num[buy + 1][sale + 1];
        }
        num[buy + 1][sale + 1] = Math.max(find(prices, sale + 2, sale) + prices[sale], find(prices, buy, sale + 1));
        return num[buy + 1][sale + 1];
    }

    /**
     * isBuy true 为买了， false 为还没买
     * true = 1, false = 0
     */
    private int find2(int[] prices, int index, boolean isBuy) {
        if (index >= prices.length)
            return 0;
        if (isBuy) {
            return Math.max(find2(prices, index + 1, true), find2(prices, index + 2, false) + prices[index]);
        } else {
            return Math.max(find2(prices, index + 1, false), find2(prices, index + 1, true) - prices[index]);
        }
    }
    
    

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        //        return find2(prices, 0, false);
        int[][] num = new int[prices.length][2];
        for (int i = prices.length - 1; i >= 0; i--) {
            num[i][1] = Math.max(i + 1 >= prices.length ? 0 : num[i + 1][1],
                    (i + 2 >= prices.length ? 0 : num[i + 2][0]) + prices[i]);
            num[i][0] = Math.max(i + 1 >= prices.length ? 0 : num[i + 1][0],
                    (i + 1 >= prices.length ? 0 : num[i + 1][1]) - prices[i]);
        }
        return num[0][0];
    }

    private void print(int[][] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.print(num[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        LeetCode309 l = new LeetCode309();
        System.out.println(l.maxProfit2(new int[] {1, 2, 3, 0, 2}));
    }
    
    
}
