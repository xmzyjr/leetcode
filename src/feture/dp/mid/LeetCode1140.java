
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode1140 {

    static class Solution {

        Integer[][] res;

        public int stoneGameII(int[] piles) {
            if (piles == null || piles.length == 0) {
                return 0;
            }
            int length = piles.length;
            res = new Integer[length][length];
            for (int i = piles.length - 2; i >= 0; i--) {
                piles[i] += piles[i + 1];
            }
            return find(length, piles, 1, 0);
        }

        /**
         * 
         */
        private int find(int length, int[] sum, int m, int index) {
            if (res[index][m] != null)
                return res[index][m];
            if (index + 2 * m >= length) {
                return sum[index];
            }
            int max = Integer.MIN_VALUE;
            for (int x = 1; x <= 2 * m; x++) {
                // 重点在这里，alex 先拿x 堆， i+x 为 li 拿。这里的表达式为 alex最多拿所有的
                // alex 实际拿的是，alex拿所有的情况，减去li拿最少的情况。
                max = Math.max(sum[index] - find(length, sum, Math.max(x, m), index + x), max);
            }
            res[index][m] = max;
            return max;
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.stoneGameII(new int[] {2, 7, 9}));
        }
    }
}
