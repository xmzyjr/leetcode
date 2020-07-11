package feture.dp.easy;

/**
 * @author lanshan
 */
public class LeetCode746 {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            if (cost == null || cost.length == 0 || cost.length == 1)
                return 0;
            for (int i = cost.length - 1; i >= 0; i--) {
                if (i + 2 >= cost.length) {
                    continue;
                }
                cost[i] += Math.min(cost[i+1], cost[i+2]);
            }
            return Math.min(cost[0], cost[1]);
        }
    }
}
