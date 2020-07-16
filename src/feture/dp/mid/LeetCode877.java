package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode877 {
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

    }
}
