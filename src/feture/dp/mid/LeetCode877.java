package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode877 {

    /**
     * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
     *
     * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
     *
     * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
     *
     * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
     *
     *  
     *
     * 示例：
     *
     * 输入：[5,3,4,5]
     * 输出：true
     * 解释：
     * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
     * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
     * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
     * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
     * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
     *  
     *
     * 提示：
     *
     * 2 <= piles.length <= 500
     * piles.length 是偶数。
     * 1 <= piles[i] <= 500
     * sum(piles) 是奇数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/stone-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean stoneGame(int[] piles) {
            if (piles == null || piles.length == 0) {
                return true;
            }
            Node[][] temp = new Node[piles.length][piles.length];
            for (int i = piles.length - 1; i >= 0; i--) {
                for (int j = i; j < piles.length; j++) {
                    temp[i][j] = new Node();
                    if (j == i) {
                        temp[i][j].fir = piles[i];
                        temp[i][j].sec = 0;
                    } else {
                        int left = piles[i] + temp[i+1][j].sec;
                        int right = piles[j] + temp[i][j-1].sec;
                        if (left>right) {
                            temp[i][j].fir = left;
                            temp[i][j].sec = temp[i+1][j].fir;
                        } else {
                            temp[i][j].fir = right;
                            temp[i][j].sec = temp[i][j-1].fir;
                        }
                    }
                }
            }
            return temp[0][piles.length-1].fir > temp[0][piles.length-1].sec;
        }

        class Node {
            int fir;
            int sec;
        }
        
        private int winFirst(int[] piles) {
            if (piles == null || piles.length == 0)
                return 0;
            return Math.max(first(piles, 0, piles.length - 1), second(piles, 0, piles.length - 1));
        }
        
        private int first(int[] piles, int start, int end) {
            if (start == end) 
                return piles[start];
            return Math.max(piles[start] + second(piles, start + 1, end), piles[end] + second(piles, start, end - 1));
        }

        private int second(int[] piles, int start, int end) {
            if (start == end)
                return 0;
            return Math.min(first(piles, start + 1, end), first(piles, start, end - 1));
        }
        
        
        

    }
}
