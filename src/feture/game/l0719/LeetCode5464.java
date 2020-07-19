package feture.game.l0719;

/**
 * @author lanshan
 */
public class LeetCode5464 {
    static class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            if (numBottles == 0 || numExchange == 0)
                return numBottles;
            int empty = 0;
            int count = 0;
            while (numBottles > 0) {
                count += numBottles;
                empty += numBottles;
                numBottles = empty / numExchange;
                empty %= numExchange;
            }
            return count;
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.numWaterBottles(15, 4));
        }
    }
}
