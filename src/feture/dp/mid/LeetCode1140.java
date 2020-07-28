
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode1140 {

    /**
     * 亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
     *
     * 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
     *
     * 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
     *
     * 游戏一直持续到所有石子都被拿走。
     *
     * 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
     *
     *  
     *
     * 示例：
     *
     * 输入：piles = [2,7,9,4,4]
     * 输出：10
     * 解释：
     * 如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。
     * 如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
     * 所以我们返回更大的 10。
     *  
     *
     * 提示：
     *
     * 1 <= piles.length <= 100
     * 1 <= piles[i] <= 10 ^ 4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/stone-game-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
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
